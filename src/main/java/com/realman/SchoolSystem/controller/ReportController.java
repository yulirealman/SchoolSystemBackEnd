package com.realman.SchoolSystem.controller;

import com.realman.SchoolSystem.pojo.JobOption;
import com.realman.SchoolSystem.pojo.Result;
import com.realman.SchoolSystem.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
       log.info("Get Emp Job Data");
       JobOption jobOption = reportService.getEmpJobData();
       return Result.success(jobOption);
    }


    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
       log.info("Get Emp Gender Data");
       List<Map<String,Object>> empGenderData = reportService.getEmpGenderData();
       return Result.success(empGenderData);
    }

    @GetMapping("studentCountData")
    public Result getStudentCountData() {
       log.info("Get Student Count Data");
        Map<String, Object> studentCountData = reportService.getStudentCountData();
       return Result.success(studentCountData);
    }
}
