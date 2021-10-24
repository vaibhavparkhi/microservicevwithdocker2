package com.javatechie.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;

    @ManyToOne
    @ToString.Exclude
    private Course course;
    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }
}
