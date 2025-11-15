package com.realman.SchoolSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    private Integer id;
    private Integer empId;
    private Date beginDate;
    private Date endDate;
    private String company;
    private String job;
}
