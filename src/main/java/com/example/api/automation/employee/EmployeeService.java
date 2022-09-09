package com.example.api.automation.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "abc", "abc@email.com"),
                new Employee(2, "xyz", "xyz@email.com")
        );
        employeeRepository.saveAll(employees);
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (!byId.isPresent())
            throw new IllegalStateException("Id is not present");
        return employeeRepository.getById(id);
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
