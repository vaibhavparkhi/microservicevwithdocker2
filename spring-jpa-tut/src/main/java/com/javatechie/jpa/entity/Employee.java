package com.javatechie.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "EmployeeType")
@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Employee(String s) {
        this.name = s;
    }



}
