package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Clazz;
import com.realman.SchoolSystem.pojo.ClazzQueryParam;
import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClazzMapper {

    Long count(@Param("param") ClazzQueryParam param);

    List<Clazz> list(@Param("param") ClazzQueryParam param,
                   @Param("offset") Integer offset);

    Clazz getClazzById(Integer id);

    void insert(Clazz clazz);

    void update(Clazz clazz);
}
