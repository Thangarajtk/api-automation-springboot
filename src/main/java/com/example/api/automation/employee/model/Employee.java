package com.example.api.automation.employee.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private String email;
}
