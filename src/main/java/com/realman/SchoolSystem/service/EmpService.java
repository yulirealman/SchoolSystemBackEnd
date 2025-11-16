package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.PageResult;

public interface EmpService {
    PageResult<Emp> page(Integer page, Integer pageSize);
}
