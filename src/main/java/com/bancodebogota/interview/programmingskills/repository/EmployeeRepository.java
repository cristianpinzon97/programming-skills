package com.bancodebogota.interview.programmingskills.repository;

import com.bancodebogota.interview.programmingskills.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Employee operations
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
