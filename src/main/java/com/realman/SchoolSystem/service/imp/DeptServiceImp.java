package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.DeptMapper;
import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {

        return deptMapper.findAll();


    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }


}
