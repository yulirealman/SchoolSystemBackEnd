package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();
    @Select("select e.*, d.name as deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc limit #{offset}, #{pageSize} ")
    List<Emp> list(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

}
