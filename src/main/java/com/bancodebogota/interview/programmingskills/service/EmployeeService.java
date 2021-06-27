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

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto createOrUpdateEmployee(EmployeeDto entity) throws RecordNotFoundException,BadRequestException {
        if(entity.getId() == null){
            throw new BadRequestException("at least a Id must be given");
        }
        Optional<Employee> employee = this.employeeRepository.findById(entity.getId());
        Employee newEntity;
        if (employee.isPresent()) {
            newEntity = employee.get();
            newEntity.setFullName(entity.getFullName());
            newEntity.setFunction(entity.getFunction());
            newEntity.setBoss(entity.getBoss());
            newEntity.setEmployees(entity.getEmployees());

            newEntity = this.employeeRepository.save(newEntity);

            return ObjectMapperUtils.map(newEntity,EmployeeDto.class);
        } else {
            newEntity = this.employeeRepository.save(ObjectMapperUtils.map(entity,Employee.class));
            entity = ObjectMapperUtils.map(newEntity,EmployeeDto.class);

            return entity;
        }
    }

    public EmployeeDto getEmployeeById(Long employeeId) throws RecordNotFoundException {

        Optional<Employee> employee = this.employeeRepository.findById(employeeId);

        if (employee.isPresent()) {
            return ObjectMapperUtils.map(employee.get(),EmployeeDto.class);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }

    }

    public List<EmployeeDto> getAllEmployees() {

        return ObjectMapperUtils.mapAll(this.employeeRepository.findAll(), EmployeeDto.class);
    }

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
