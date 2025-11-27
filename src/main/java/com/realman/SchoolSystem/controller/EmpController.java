package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.anno.Log;
import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Log
    public Result save(@RequestBody Emp emp) {
        log.info("Save Emp {}",emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    @Log
    public Result delete(@RequestParam("ids") List<Integer> ids) {
        log.info("Delete Emp By Id {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        log.info("Search Emp By Id {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }


    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp) {
        log.info("Update Emp {}", emp);

        empService.update(emp);
        return  Result.success();
    }


    @GetMapping("/list")
    public Result list() {
        log.info("List All Emp");
        List<Emp> list = empService.list();
        return Result.success(list);
    }
}
