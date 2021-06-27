package com.bancodebogota.interview.programmingskills.service;

import com.bancodebogota.interview.programmingskills.dto.EmployeeDto;
import com.bancodebogota.interview.programmingskills.model.Employee;
import com.bancodebogota.interview.programmingskills.repository.EmployeeRepository;
import com.bancodebogota.interview.programmingskills.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee (EmployeeDto employeeDto){

        Employee employee = ObjectMapperUtils.map(employeeDto,Employee.class);
        return ObjectMapperUtils.map(this.employeeRepository.save(employee),EmployeeDto.class);

    }

    public EmployeeDto getEmployee (Integer employeeId){

        return ObjectMapperUtils.map(this.employeeRepository.getById(employeeId),EmployeeDto.class);

    }

    public List<EmployeeDto> getEmployees(){

        return ObjectMapperUtils.mapAll(this.employeeRepository.findAll(),EmployeeDto.class);
    }
}
