package com.example.api.automation;

import com.example.api.automation.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBootTestRestTemplateTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${base.url}")
	private String baseUrl;

	@LocalServerPort
	private int port;

	@Test
	void testGetEmployeeById() {
		// Arrange
		Employee employee = new Employee(1, "abc", "abc@email.com");

		// Act
		Employee responseEntity = this.restTemplate.getForObject(baseUrl + ":" + port + "/employees/1", Employee.class);

		// Assert
		assertThat(responseEntity).isEqualTo(employee);
	}

	@Test
	void testGetEmployees() {
		// Arrange
		Employee employee = new Employee(1, "abc", "abc@email.com");

		// Act
		Employee[] responseEntity = this.restTemplate.getForObject(baseUrl + ":" + port + "/employees", Employee[].class);
		var responseEmployee = Arrays.stream(responseEntity).filter(x -> x.getId() == 1).findFirst().get();

		// Assert
		assertThat(responseEmployee).isEqualTo(employee);
	}

	@Test
	void testPostEmployees() {
		// Arrange
		Employee employee = new Employee(4, "new_post_test", "newposttest@email.com");

		// Act
		var responseEntity = this.restTemplate.postForObject(baseUrl + ":" + port + "/employees", employee, Employee[].class);
		var response = Arrays.stream(responseEntity)
				.filter(x -> x.getId() == 4).findFirst().get();

		// Assert
		assertThat(response).isEqualTo(employee);
	}
}
