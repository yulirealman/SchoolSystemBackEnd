package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // controller's return value is what we want to send to frontend
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        System.out.println("Search All Data From Department");
       List<Dept> deptList = deptService.findAll();
       return Result.success(deptList);
    }

}
