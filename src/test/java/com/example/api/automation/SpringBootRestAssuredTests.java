package com.example.api.automation;

import com.example.api.automation.employee.model.Employee;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBootRestAssuredTests {

    @Value("${base.url}")
    private String baseUrl;

    @LocalServerPort
    private int port;

    @Test
    void testGetEmployeeById() {
        given()
                .baseUri(baseUrl)
                .port(port)
                .basePath("/employees/1")
                .get()
                .then()
                .assertThat()
                .body("name", Matchers.equalTo("abc"));
    }

    @Test
    void testGetEmployees() {
        // Arrange
        Employee employee = new Employee(1, "abc", "abc@email.com");

        // Act
        var response = given().baseUri(baseUrl)
                .port(port)
                .basePath("/employees/1")
                .get();
        var responseEntity = response.body().as(Employee.class);

        // Assert
        assertThat(responseEntity).isEqualTo(employee);
    }

    @Test
    void testPostEmployees() {
        // Arrange
        Employee employee = new Employee(4, "new_post_test", "newposttest@email.com");

        // Act
        var response = given().baseUri(baseUrl)
                .port(port)
                .basePath("/employees")
                .contentType("application/json")
                .body(employee)
                .post();
        var responseEntity = response.body().as(Employee.class);

        // Assert
        assertThat(responseEntity).isEqualTo(employee);
    }

    @Test
    void testUpdateEmployee() {
        // Arrange
        Employee employee = new Employee(4, "updated_name", "updated_email@email.com");

        // Act
        var response = given().baseUri(baseUrl)
                .port(port)
                .basePath("/employees")
                .contentType("application/json")
                .body(employee)
                .put();
        var responseEntity = response.body().as(Employee.class);

        // Assert
        assertThat(responseEntity).isEqualTo(employee);
    }
}
