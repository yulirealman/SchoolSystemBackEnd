package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {

    Long count(@Param("param") EmpQueryParam param);

    List<Emp> list(@Param("param") EmpQueryParam param,
                   @Param("offset") Integer offset);


    void insert(@Param("emp")Emp emp);

    void deleteByIds(List<Integer> ids);
}
