package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CourseSpringRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository springDataRepository;


    @Test
    public void findById_Test() {
        Optional<Course> courseOptional = springDataRepository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void playingWithSpringDataRespository() {
//        Course course = new Course("AWS - Certification");
//        springDataRepository.save(course);
//        course.setName("AWS - Certification - updated");
//        springDataRepository.save(course);

        logger.info("Courses - > {}", springDataRepository.findAll());


    }

    @Test
    public void sort_Test() {
        List<Course> courses = springDataRepository.findAll(Sort.by(Sort.Direction.DESC, "name").and(Sort.by("createdDate")));
        logger.info("Sorted Courses - > {}", courses);
    }


    @Test
    public void pagination_Test() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> page1 = springDataRepository.findAll(pageRequest);
        Pageable secondPage = page1.nextPageable();
        Page<Course> page2 = springDataRepository.findAll(secondPage);
        logger.info("Sorted Courses - > {}", page2.getContent());
    }

    @Test
    public void findByName_Test() {

        logger.info("Courses With 50 Steps - > {}", springDataRepository.coursesWithNameQuery());
    }
}