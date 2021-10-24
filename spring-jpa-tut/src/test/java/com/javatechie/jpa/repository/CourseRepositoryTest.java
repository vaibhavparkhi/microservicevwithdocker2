package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Course;
import com.javatechie.jpa.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById_Test() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteBy_Id() {
        courseRepository.deleteCourse(10004L);
        assertNull(courseRepository.findById(10004L));
    }

    @Test
    @DirtiesContext
    public void save_basic(){
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA in 50 steps", course.getName());
        course.setName("JPA in 50 steps -- updated");
        courseRepository.save(course);
        Course course1 = courseRepository.findById(10001L);
        assertEquals("JPA in 50 steps -- updated", course1.getName());
    }


    @Test
    @DirtiesContext
    public void playWithEntityManager(){
        System.out.println("Entity Manager Started....");
        courseRepository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retriveReviewForCourse(){
       Course course = courseRepository.findById(10001L);
        System.out.println(course.getReviews());
    }

    @Test
    @Transactional()
    public void retriveCourseForReview(){
        Review review = entityManager.find(Review.class, 30001L);
        System.out.println(review.getCourse());
    }
}