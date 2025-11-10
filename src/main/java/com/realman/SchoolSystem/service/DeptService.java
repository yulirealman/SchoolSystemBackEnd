package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();


    void deleteById(Integer id);

    void insert(Dept dept);

    Dept getById(Integer id);
}
