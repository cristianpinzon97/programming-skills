package com.bancodebogota.interview.programmingskills.service;

import com.bancodebogota.interview.programmingskills.dto.EmployeeDto;
import com.bancodebogota.interview.programmingskills.exception.BadRequestException;
import com.bancodebogota.interview.programmingskills.exception.RecordNotFoundException;
import com.bancodebogota.interview.programmingskills.model.Employee;
import com.bancodebogota.interview.programmingskills.repository.EmployeeRepository;
import com.bancodebogota.interview.programmingskills.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EmployeeServiceImpl implementation for {@link EmployeeService}
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Creates or updates an employ
     * @param employeeDto to be created or updated
     * @return the employee
     */
    @Override
    public EmployeeDto createOrUpdateEmployee(EmployeeDto employeeDto) throws RecordNotFoundException,BadRequestException {
        if(employeeDto.getId() == null){
            throw new BadRequestException("at least a Id must be given");
        }
        Optional<Employee> employee = this.employeeRepository.findById(employeeDto.getId());
        Employee newEntity;
        if (employee.isPresent()) {
            newEntity = employee.get();
            newEntity.setFullName(employeeDto.getFullName());
            newEntity.setFunction(employeeDto.getFunction());
            newEntity.setBoss(employeeDto.getBoss());
            newEntity.setEmployees(employeeDto.getEmployees());

            newEntity = this.employeeRepository.save(newEntity);

            return ObjectMapperUtils.map(newEntity,EmployeeDto.class);
        } else {
            newEntity = this.employeeRepository.save(ObjectMapperUtils.map(employeeDto,Employee.class));
            employeeDto = ObjectMapperUtils.map(newEntity,EmployeeDto.class);

            return employeeDto;
        }
    }

    /**
     * Gets an employee by Id
     * @param employeeId of the employee
     * @return the employee found
     */
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws RecordNotFoundException {

        Optional<Employee> employee = this.employeeRepository.findById(employeeId);

        if (employee.isPresent()) {
            return ObjectMapperUtils.map(employee.get(),EmployeeDto.class);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }

    }

    /**
     * Gets all the employees
     * @return list of employees
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {

        return ObjectMapperUtils.mapAll(this.employeeRepository.findAll(), EmployeeDto.class);
    }

    /**
     * Sets a boss to an employee
     * @param employeeId of the employee
     * @param boss data
     * @return the employ updated
     */
    @Override
    public EmployeeDto setBossToEmployee(Long employeeId, EmployeeDto boss) throws RecordNotFoundException {


        if (boss.getId() == null) {
            boss = createOrUpdateEmployee(boss);
        } else {
            Optional<Employee> optionalBoss = this.employeeRepository.findById(boss.getId());
            if (optionalBoss.isPresent()) {
                boss = ObjectMapperUtils.map(optionalBoss.get(),EmployeeDto.class);
            } else {
                boss = createOrUpdateEmployee(boss);
            }
        }


        Employee employee;
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }

        employee.setBoss(ObjectMapperUtils.map(boss,Employee.class));

        return ObjectMapperUtils.map(this.employeeRepository.save(employee),EmployeeDto.class);


    }

}
