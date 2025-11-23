package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import com.realman.SchoolSystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("Save student {}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("Get student {}",id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("Update student {}",student);
        studentService.update(student);
        return Result.success();
    }
}
