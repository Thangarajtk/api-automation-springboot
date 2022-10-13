package com.example.api.automation;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootRestAssuredTests {

    @Value("${base.uri}")
    private String baseUri;

    @LocalServerPort
    private int port;

    @Test
    public void testGetEmployeeById() {
        given()
                .baseUri(baseUri)
                .port(port)
                .basePath("/employees/1")
                .get()
                .then()
                .assertThat()
                .body("name", Matchers.equalTo("abc"));
    }
}
