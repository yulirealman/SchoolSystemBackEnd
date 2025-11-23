package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import com.realman.SchoolSystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam param) {
        log.info("Search by page {}",param);
        PageResult<Student> pageResult  =  studentService.page(param);
        return Result.success(pageResult);
    }
}
