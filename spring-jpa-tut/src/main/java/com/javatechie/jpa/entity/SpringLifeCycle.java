package com.javatechie.jpa.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Setter
@Component
public class SpringLifeCycle implements BeanPostProcessor {

    private String name;

    private String add;

    @PostConstruct
    public void init() throws  ClassNotFoundException{
        System.out.println("Inside init method");
    }

}
