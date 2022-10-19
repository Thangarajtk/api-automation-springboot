package com.example.api.automation.employee.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity // Repository to store the data
public class Employee {

    @Id
    private int id;
    private String name;
    private String email;
}
