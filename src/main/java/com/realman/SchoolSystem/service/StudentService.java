package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam param);

    void save(Student student);

    Student getById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void addViolation(Integer id, Short score);
}
