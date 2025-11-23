package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Param;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam param);
}
