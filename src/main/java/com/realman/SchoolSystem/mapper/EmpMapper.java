package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import com.realman.SchoolSystem.pojo.JobOption;
import com.realman.SchoolSystem.pojo.JobStatics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    Long count(@Param("param") EmpQueryParam param);

    List<Emp> list(@Param("param") EmpQueryParam param,
                   @Param("offset") Integer offset);


    void insert(@Param("emp")Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    List<JobStatics> countEmpJobData();

    List<Map<String, Object>> countEmpGenderData();

    List<Emp> getAll();
}
