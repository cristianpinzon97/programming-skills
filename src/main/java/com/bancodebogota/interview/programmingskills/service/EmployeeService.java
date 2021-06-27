package com.bancodebogota.interview.programmingskills.service;

import com.bancodebogota.interview.programmingskills.dto.EmployeeDto;

import java.util.List;

/**
 * Provides services to manage employees
 *
 */
public interface EmployeeService {

    /**
     * Creates or updates an employ
     * @param employeeDto to be created or updated
     * @return the employee
     */
    EmployeeDto createOrUpdateEmployee(EmployeeDto employeeDto);

    /**
     * Gets an employee by Id
     * @param employeeId of the employee
     * @return the employee found
     */
    EmployeeDto getEmployeeById(Long employeeId);

    /**
     * Gets all the employees
     * @return list of employees
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * Sets a boss to an employee
     * @param employeeId of the employee
     * @param boss data
     * @return the employ updated
     */
    EmployeeDto setBossToEmployee(Long employeeId, EmployeeDto boss);
}
