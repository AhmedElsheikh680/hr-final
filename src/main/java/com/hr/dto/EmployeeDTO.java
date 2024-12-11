package com.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO implements Serializable {

    private long id;
    private String empFirstName;
    private String empLastName;
    private String fullName;
    private double empSalary;
    private LocalDate hireDate;
}
