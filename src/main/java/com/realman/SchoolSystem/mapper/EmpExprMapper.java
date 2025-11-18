package com.realman.SchoolSystem.mapper;

import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);
}
