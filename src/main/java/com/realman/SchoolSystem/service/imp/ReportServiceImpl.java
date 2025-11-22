package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.EmpMapper;
import com.realman.SchoolSystem.pojo.JobOption;
import com.realman.SchoolSystem.pojo.JobStatics;
import com.realman.SchoolSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getEmpJobData() {
        List<JobStatics> jobStatics = empMapper.countEmpJobData();
        List<String> jobName = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        jobStatics.forEach(item -> {
            jobName.add(item.getJobName());
            total.add(item.getTotal());
        });

        return new JobOption(jobName, total);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
       return empMapper.countEmpGenderData();
    }

}
