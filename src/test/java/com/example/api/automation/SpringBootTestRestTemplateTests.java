package com.example.api.automation;

import com.example.api.automation.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBootTestRestTemplateTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void testGetEmployeeById() {
		// Arrange
		final String baseUri = "http://localhost:" + port + "/employees/1";
		Employee employee = new Employee(1, "abc", "abc@email.com");

		// Act
		Employee responseEntity = this.restTemplate.getForObject(baseUri, Employee.class);

		// Assert
		assertThat(responseEntity).isEqualTo(employee);
	}

	@Test
	void testGetEmployees() {
		// Arrange
		final String baseUri = "http://localhost:" + port + "/employees";
		Employee employee = new Employee(1, "abc", "abc@email.com");

		// Act
		Employee[] responseEntity = this.restTemplate.getForObject(baseUri, Employee[].class);
		var responseEmployee = Arrays.stream(responseEntity).filter(x -> x.getId() == 1).findFirst().get();

		// Assert
		assertThat(responseEmployee).isEqualTo(employee);
	}

	@Test
	void testPostEmployees() {
		// Arrange
		final String baseUri = "http://localhost:" + port + "/employees";
		Employee employee = new Employee(4, "new_post_test", "newposttest@email.com");

		// Act
		var responseEntity = this.restTemplate.postForObject(baseUri, employee, Employee.class);

		// Assert
		assertThat(responseEntity).isEqualTo(employee);
	}
}
