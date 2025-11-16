package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.EmpMapper;
import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total = empMapper.count();

        Integer offset = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(offset, pageSize);



        return new PageResult<Emp>(total,rows);
    }
}
