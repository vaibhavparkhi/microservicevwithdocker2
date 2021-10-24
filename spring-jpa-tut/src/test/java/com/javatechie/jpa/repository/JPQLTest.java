package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
class JPQLTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    @Test
    public void jpql_Test() {
        Query query = em.createNamedQuery("get_all_courses");
        var resultList = query.getResultList();
        logger.info("Select c from Course c --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }


    @Test
    public void jpql_typed() {


        TypedQuery<Course> query =
                em.createNamedQuery("get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query =
                em.createNamedQuery("get_all_courses_50_steps", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }
}