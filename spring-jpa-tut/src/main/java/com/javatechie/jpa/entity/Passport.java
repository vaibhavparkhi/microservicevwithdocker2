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
@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    @ToString.Exclude
    private Student student;
    public Passport(String number) {
        this.number = number;
    }
}
