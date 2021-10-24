package com.javatechie.jpa;

import com.javatechie.jpa.entity.Review;
import com.javatechie.jpa.entity.SpringLifeCycle;
import com.javatechie.jpa.repository.CourseRepository;
import com.javatechie.jpa.repository.EmployeeRepository;
import com.javatechie.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {
        //SpringApplication.run(JpaApplication.class, args);

        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
        SpringLifeCycle lifeCycle = context.getBean(SpringLifeCycle.class);

        System.out.println(lifeCycle);
    }


    @Override
    public void run(String... args) throws Exception {

        //courseRepository.addReviewForCourse();
        List<Review> reviews = List.of(new Review("Great Hand of stuff", "5"), new Review("Hatsoff", "5"));
        //courseRepository.addReviewForCourse(10002L, reviews);
        //studentRepository.insertStudentWithCourse();
    	//courseRepository.playWithEntityManager();
       // employeeRepository.insert(new FullTimeEmployee("Vaibhav", new BigDecimal("10000")));
        //employeeRepository.insert(new PartTimeEmployee("DD", new BigDecimal("100")));

        //logger.info("Employees - > {}", employeeRepository.employees());

//		Course course = courseRepository.findById(10001L);
//
//		logger.info("Course 10001 {}", course);
//
//		courseRepository.save(new Course("React in 50 Steps"));
//		//courseRepository.deleteCourse(10004L);

    }
}
