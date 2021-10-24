package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Passport;
import com.javatechie.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class StudentRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void findStudentAndPassport_Test() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional // persistent context
    public void someTest(){

        Student student = em.find(Student.class, 20002L);

        Passport passport = student.getPassport();

        passport.setNumber("E1234567");

        student.setName("Dane Chris");
    }


    @Test
    @Transactional
    public void findStudentAndPassport_Test2() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("Student -> {}", passport.getStudent());
    }


    @Test
    @Transactional
    public void findStudentAndCourses_Test2() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("Courses -> {}", student.getCourses());
    }


}