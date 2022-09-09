package com.example.api.automation.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private String email;
}
