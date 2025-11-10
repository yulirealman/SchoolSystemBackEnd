package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer id) {
        System.out.println("Delete Department By Id");
        deptService.deleteById(id);
        return Result.success();
    }


    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept) {
        //use request body instead of request param at post or put request
        System.out.println("Add Department");
        deptService.insert(dept);
        return Result.success();
    }


}
