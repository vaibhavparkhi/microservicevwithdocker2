package com.javatechie.jpa.repository;


import com.javatechie.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);

    @Query("Select c from Course c where name like '%50 steps'")
    List<Course> coursesWith50Steps();

    @Query(value = "Select * from Course c where name like '%50 steps'", nativeQuery = true)
    List<Course> coursesWithNativeQuery();


    @Query(name = "get_all_courses_50_steps")
    List<Course> coursesWithNameQuery();
}
