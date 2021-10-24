package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@SpringBootTest
class NativeQueryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    @Test
    public void native_Test() {
        Query query = em.createNativeQuery("select * from course", Course.class);
        var resultList = query.getResultList();
        logger.info("Select c from Course c --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    public void native_with_parameters_Test() {
        Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
        query.setParameter(1, 10001L);
        var resultList = query.getResultList();
        logger.info("select * from course where id = ? --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    public void native_with_named_parameters_Test() {
        Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        var resultList = query.getResultList();
        logger.info("select * from course where id = :id --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }


    @Test
    @Transactional
    public void native_update_set_last_update_Test() {
        Query query = em.createNativeQuery("update sql_jpa_tut.course set updated_date=sysdate()", Course.class);
        var n = query.executeUpdate();
        em.flush();
        logger.info("Select c from Course c --> {}", n);
        Query query1 = em.createNativeQuery("select * from course", Course.class);
        var resultList = query1.getResultList();
        logger.info("Select c from Course c --> {}", resultList);
        //assertEquals("JPA in 50 steps", course.getName());
    }

}