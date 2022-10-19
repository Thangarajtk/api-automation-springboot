package com.example.api.automation;

import com.example.api.automation.employee.controller.EmployeeController;
import com.example.api.automation.employee.model.Employee;
import com.example.api.automation.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class MockMvcWithSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById() throws Exception {
        // Arrange
        Employee employee = new Employee(1, "abc", "abc@email.com");

        // Act
        when(employeeService.getEmployee(1)).thenReturn(employee);

        // Assertion
        this.mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetEmployeeList() throws Exception {
        // Arrange
        List<Employee> employees = List.of(
                new Employee(1, "abc", "abc@email.com"),
                new Employee(2, "xyz", "xyz@email.com"),
                Employee.builder()
                        .id(3)
                        .name("test")
                        .email("test@email.com")
                        .build()
        );

        // Act
        when(employeeService.getEmployees()).thenReturn(employees);

        // Assertion
        var result = this.mockMvc.perform(get("/employees"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("abc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("xyz@email.com"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
