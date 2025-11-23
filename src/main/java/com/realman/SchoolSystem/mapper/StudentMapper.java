package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    Long countStudentByClazzId(Integer clazzId);

    Long count(@Param("param") StudentQueryParam param);

    List<Student> list(@Param("param")StudentQueryParam param,
                       @Param("offset") Integer offset);
}
