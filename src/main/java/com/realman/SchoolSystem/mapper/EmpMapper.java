package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    Long count(@Param("param") EmpQueryParam param);

    List<Emp> list(@Param("param") EmpQueryParam param,
                   @Param("offset") Integer offset);


}
