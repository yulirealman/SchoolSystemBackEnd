package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.*;
import com.realman.SchoolSystem.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(ClazzQueryParam param) {
        log.info("Search by page {}",param);
        PageResult<Clazz> pageResult  =  clazzService.page(param);
        return Result.success(pageResult);
    }
}

