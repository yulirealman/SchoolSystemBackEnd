package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.EmpExprMapper;
import com.realman.SchoolSystem.mapper.EmpMapper;
import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpExpr;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
}
