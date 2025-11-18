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
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
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
}
