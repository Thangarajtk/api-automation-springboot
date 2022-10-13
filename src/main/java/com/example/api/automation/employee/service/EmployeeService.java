package com.example.api.automation.employee.service;

import com.example.api.automation.employee.entity.EmployeeRepository;
import com.example.api.automation.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employees = List.of(
                new Employee(1, "abc", "abc@email.com"),
                new Employee(2, "xyz", "xyz@email.com"),
                Employee.builder()
                        .id(3)
                        .name("test")
                        .email("test@email.com")
                        .build()
        );
        employeeRepository.saveAll(employees);
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (!byId.isPresent())
            throw new IllegalStateException("Id is not present");
        return employeeRepository.getReferenceById(id);
    }

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            throw new IllegalStateException("Id already exists");
        }
        employeeRepository.save(employee);
        return employee;
    }

    public String deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalStateException("Id is not present");
        }
        employeeRepository.deleteById(id);
        return "success";
    }

    public Employee editEmployee(Employee employee, int id) {
        if (!employeeRepository.existsById(id)) {
            throw new IllegalStateException("Id is not present");
        }
        employeeRepository.deleteById(id);
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getEmployeeMatchingQuery(int limit) {
        return employeeRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
