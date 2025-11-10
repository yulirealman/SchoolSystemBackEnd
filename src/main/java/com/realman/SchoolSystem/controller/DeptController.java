package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.Dept;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j4j              //this is same as log we defined , provided by lombok
@RequestMapping("/depts")
@RestController
public class DeptController {
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    // controller's return value is what we want to send to frontend
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("Search All Data From Department");

       List<Dept> deptList = deptService.findAll();
       return Result.success(deptList);
    }


    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {

        log.info("Delete Department By ID {}", id);
        deptService.deleteById(id);
        return Result.success();
    }


    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        //use request body instead of request param at post or put request

        log.info("Add Department {}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        //often use this when we need to edit

        log.info("Search Department By Id {}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {

        log.info("Update Department {}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
