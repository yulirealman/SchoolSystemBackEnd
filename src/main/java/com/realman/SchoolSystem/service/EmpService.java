package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import com.realman.SchoolSystem.pojo.JobOption;
import com.realman.SchoolSystem.pojo.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam  param);

    void save(Emp emp);

    void delete(List< Integer> id);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> list();
}
