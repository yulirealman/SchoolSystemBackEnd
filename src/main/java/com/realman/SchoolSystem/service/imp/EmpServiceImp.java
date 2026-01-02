package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.EmpExprMapper;
import com.realman.SchoolSystem.mapper.EmpMapper;
import com.realman.SchoolSystem.pojo.*;
import com.realman.SchoolSystem.service.EmpService;
import com.realman.SchoolSystem.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam  param) {
        Long total = empMapper.count(param);

        Integer offset = (param.getPage() - 1) * param.getPageSize();
        List<Emp> rows = empMapper.list(param,offset);



        return new PageResult<Emp>(total,rows);
    }

    @Transactional(rollbackFor = {Exception.class}) //use transaction when involve multiple  tables
    @Override
    public void save(Emp emp) {
        if(emp.getImage()== null || emp.getImage().equals( "")){
            emp.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFly7kLA15avfhCDN6_NHQIYwbVZG9muLziycroyu-Hw&s");}
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){

            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });

            empExprMapper.insertBatch(exprList);
        }


    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List< Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }



    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);

    }



    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        // so emp contains updated fields, not only basic info
        // but also emp experience list
        // we will just remove all emp experience from database
        // and insert this new emp experience list
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);


        // this deletes all emp experience by emp id
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        // now add new emp experience
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());

            });
            empExprMapper.insertBatch(exprList);
        }

    }

    @Override
    public List<Emp> list() {
        return empMapper.getAll();
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp result = empMapper.selectByUsernameAndPassword(emp);

        if(result != null){
            log.info("login success ,{}",result);
            log.info("generate token");
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",result.getId());
            claims.put("username",result.getUsername());
            String token = JwtUtils.generateToken(claims);
            return new LoginInfo(result.getId(),result.getUsername(),result.getName(),token);
        }

        return null;
    }

}
