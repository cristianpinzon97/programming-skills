package com.bancodebogota.interview.programmingskills.controller;

import com.bancodebogota.interview.programmingskills.dto.EmployeeDto;
import com.bancodebogota.interview.programmingskills.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable(value = "id") Integer employeeId){
        return this.employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employee){

        return this.employeeService.createEmployee(employee);
    }
}
