package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // controller's return value is what we want to send to frontend
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        System.out.println("Search All Data From Department");
       List<Dept> deptList = deptService.findAll();
       return Result.success(deptList);
    }


    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
        System.out.println("Delete Department By Id");
        deptService.deleteById(id);
        return Result.success();
    }


    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        //use request body instead of request param at post or put request
        System.out.println("Add Department");
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        //often use this when we need to edit
        System.out.println("Search Department By Id");
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("Update Department");
        deptService.update(dept);
        return Result.success();
    }

}
