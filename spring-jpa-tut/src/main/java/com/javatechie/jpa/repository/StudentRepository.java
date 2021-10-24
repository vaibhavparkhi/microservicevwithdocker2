package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.Course;
import com.javatechie.jpa.entity.Passport;
import com.javatechie.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student save(Student course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public void deleteStudent(Long studentId) {
        Student student = findById(studentId);
        entityManager.remove(student);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z1234567");
        entityManager.persist(passport);
        Student student1 = new Student("Mike");
        student1.setPassport(passport);
        entityManager.persist(student1);

    }

    public  void insertStudentWithCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 steps");
        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourses(course);
        course.addStudent(student);

        entityManager.persist(student);

    }


}
