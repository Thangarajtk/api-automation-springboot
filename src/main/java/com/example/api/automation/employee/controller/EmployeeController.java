package com.example.api.automation.employee.controller;

import com.example.api.automation.employee.service.EmployeeService;
import com.example.api.automation.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

//    @GetMapping("/employees/{id}")
//    public List<Employee> getEmployeeMatchingQuery(@RequestParam(required = false) int limit) {
//        return employeeService.getEmployeeMatchingQuery(limit);
//    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.updateEmployee(employee, id);
    }
}
