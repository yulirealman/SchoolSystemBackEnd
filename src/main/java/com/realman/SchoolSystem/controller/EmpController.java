package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;



    @GetMapping
    public Result page(EmpQueryParam  param) {
        log.info("Search by page {}",param);
        PageResult<Emp> pageResult  =  empService.page(param);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("Save Emp {}",emp);
        empService.save(emp);
        return Result.success();
    }


}
