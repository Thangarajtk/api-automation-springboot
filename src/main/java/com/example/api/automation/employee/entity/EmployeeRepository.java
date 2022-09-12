package com.example.api.automation.employee.entity;

import com.example.api.automation.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
