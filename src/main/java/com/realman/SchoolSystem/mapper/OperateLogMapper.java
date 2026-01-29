package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    @Insert("INSERT INTO operate_log(" +
            "operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time" +
            ") VALUES (" +
            "#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime}" +
            ")")
    void insert(OperateLog log);



    @Select("SELECT o.*, e.name As operate_emp_name FROM operate_log o LEFT JOIN emp e ON e.id = o.operate_emp_id ORDER BY operate_time DESC LIMIT #{offset}, #{pageSize} ")
    List<OperateLog> list(Integer offset, Integer pageSize);

    @Select("SELECT count(*) FROM operate_log")
    Long count();
}