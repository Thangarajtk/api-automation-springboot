package com.example.api.automation.employee.service;

import com.example.api.automation.employee.entity.EmployeeRepository;
import com.example.api.automation.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employeesList = List.of(
            new Employee(1, "abc", "abc@email.com"),
            new Employee(2, "xyz", "xyz@email.com"),
            Employee.builder()
                    .id(3)
                    .name("test")
                    .email("test@email.com")
                    .build()
    );

    public List<Employee> getEmployees() {

//        employeeRepository.saveAll(employees);
//        return employeeRepository.findAll();

        return employeesList;
    }

    public Employee getEmployee(int id) {
//        Optional<Employee> byId = employeeRepository.findById(id);
//        if (!byId.isPresent())
//            throw new IllegalStateException("Id is not present");
//        return employeeRepository.getReferenceById(id);

        return employeesList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst().get();
    }

    public List<Employee> addEmployee(Employee employee) {
//        if (employeeRepository.existsById(employee.getId())) {
//            throw new IllegalStateException("Id already exists");
//        }
//        employeeRepository.save(employee);
//        return employee;

        employeesList.add(employee);
        return employeesList;
    }

    public List<Employee> deleteEmployee(int id) {
//        if (!employeeRepository.existsById(id)) {
//            throw new IllegalStateException("Id is not present");
//        }
//        employeeRepository.deleteById(id);
//        return "success";

        employeesList.removeIf(employee -> employee.getId() == id);
        return employeesList;
    }

    public Employee updateEmployee(Employee employee, int id) {
//        if (!employeeRepository.existsById(id)) {
//            throw new IllegalStateException("Id is not present");
//        }
//        employeeRepository.deleteById(id);
//        employeeRepository.save(employee);
//        return employee;

        return employeesList.stream()
                .filter(x -> x.getId() == id)
                .peek(o -> o.setName(employee.getName()))
                .peek(o -> o.setEmail(employee.getEmail()))
                .findFirst().get();
    }

    public List<Employee> getEmployeeMatchingQuery(int limit) {
        return employeeRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
