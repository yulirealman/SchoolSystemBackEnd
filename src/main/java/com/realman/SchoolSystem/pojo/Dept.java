package com.realman.SchoolSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;                // ID, primary key
    private String name;               // Department name
    private LocalDateTime createTime;  // Creating time
    private LocalDateTime updateTime;  // Updating time
}