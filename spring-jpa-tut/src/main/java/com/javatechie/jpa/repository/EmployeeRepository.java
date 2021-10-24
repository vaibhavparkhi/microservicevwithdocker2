package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional()
public class EmployeeRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> employees(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
