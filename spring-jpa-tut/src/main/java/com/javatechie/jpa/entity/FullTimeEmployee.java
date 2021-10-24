package com.javatechie.jpa.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;

    protected FullTimeEmployee(){}

    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }


}
