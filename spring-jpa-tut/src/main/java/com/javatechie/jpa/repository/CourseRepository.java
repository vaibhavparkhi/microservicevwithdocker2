package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.Course;
import com.javatechie.jpa.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }


    public void deleteCourse(Long courseId) {
        Course course = findById(courseId);
        entityManager.remove(course);
    }

    public void playWithEntityManager(){
        Course course1 = new Course("Web service in 100 steps");
        entityManager.persist(course1);
        Course course2 = findById(10001L);
        course2.setName("JPA in 50 steps -- updated");
    }

    public void addReviewForCourse() {
        Course course = findById(10003L);
        logger.info("Reviews -> {}",course.getReviews());

        Review review1 = new Review("Great Hand of stuff", "5");
        Review review2 = new Review("Hatsoff", "5");

        //
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);

    }

    public void addReviewForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("Reviews -> {}",course.getReviews());
        reviews.forEach(review -> {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        });
    }
}
