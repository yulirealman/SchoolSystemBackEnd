package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.DeptMapper;
import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public void insert(Dept dept) {
        //by default post request will not have createTime and updateTime
        //so we fill it up at service layer
        if(dept !=null){
            dept.setCreateTime(LocalDateTime.now());
            dept.setUpdateTime(LocalDateTime.now());
        }
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById( id);
    }


}
