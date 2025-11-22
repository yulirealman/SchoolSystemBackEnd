package com.realman.SchoolSystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Long countStudentByClazzId(Integer clazzId);
}
