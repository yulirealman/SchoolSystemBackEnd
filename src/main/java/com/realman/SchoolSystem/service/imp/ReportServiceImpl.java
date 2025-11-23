package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.EmpMapper;
import com.realman.SchoolSystem.mapper.StudentMapper;
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
    @Autowired
    private StudentMapper studentMapper;
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

    @Override
    public Map<String, Object> getStudentCountData() {
        List<Map<String, Object>> list = studentMapper.countStudentData();
        System.out.println(list);

        List<Object> dataList = list.stream()
                .map(m -> m.get("dataList"))
                .toList();

        List<Object> clazzList = list.stream()
                .map(m -> m.get("clazzList"))
                .toList();

        // Return as a single map for frontend
        return Map.of(
                "dataList", dataList,
                "clazzList", clazzList
        );
    }


}
