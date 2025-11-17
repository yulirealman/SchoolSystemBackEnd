package com.realman.SchoolSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    private Integer id;
    private Integer empId;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private String company;
    private String job;
}
