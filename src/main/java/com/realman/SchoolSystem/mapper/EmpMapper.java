package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    Long count();

    List<Emp> list(@Param("name") String name,
                   @Param("gender") Integer gender,
                   @Param("begin") LocalDate begin,
                   @Param("end") LocalDate end,
                   @Param("offset") Integer offset,
                   @Param("pageSize") Integer pageSize);


}
