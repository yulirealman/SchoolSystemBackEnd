package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();
}
