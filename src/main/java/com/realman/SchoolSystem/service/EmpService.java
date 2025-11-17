package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(String name, Integer gender, LocalDate begin, LocalDate end,Integer page, Integer pageSize);
}
