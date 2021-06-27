package com.bancodebogota.interview.programmingskills.controller;

import com.bancodebogota.interview.programmingskills.exception.BadRequestException;
import com.bancodebogota.interview.programmingskills.exception.RecordNotFoundException;
import com.bancodebogota.interview.programmingskills.dto.EmployeeDto;
import com.bancodebogota.interview.programmingskills.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> list = this.employeeService.getAllEmployees();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(value = "id") Long employeeId){
        try {
            EmployeeDto entity = this.employeeService.getEmployeeById(employeeId);
            return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createOrUpdateEmployee(@RequestBody EmployeeDto employee) {
        try {
            EmployeeDto updated = this.employeeService.createOrUpdateEmployee(employee);
            return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("{employeeId}/bosses")
    public ResponseEntity<EmployeeDto> setBoss(@PathVariable Long employeeId, @RequestBody EmployeeDto bossDto) {

        try {
            EmployeeDto updated = this.employeeService.setBossToEmployee(employeeId, bossDto);
            return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
