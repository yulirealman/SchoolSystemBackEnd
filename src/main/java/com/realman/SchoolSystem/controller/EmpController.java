package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;



    @GetMapping
    public Result page(String name,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name="pageSize", defaultValue = "10") Integer pageSize) {
        log.info("Search by page {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageResult<Emp> pageResult  =  empService.page(name, gender, begin, end,page, pageSize);
        return Result.success(pageResult);
    }


}
