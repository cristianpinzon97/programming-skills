package com.bancodebogota.interview.programmingskills.dto;

import com.bancodebogota.interview.programmingskills.model.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * DTO fot Employee
 */
@Getter
@Setter
public class EmployeeDto {

    private Long id;

    private String fullName;

    private String function;

    private String email;

    private String phone;

    private Employee boss;

    private List<Employee> employees;
}
