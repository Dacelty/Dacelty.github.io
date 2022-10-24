package com.example.ktRESTAPI.repository;

import com.example.ktRESTAPI.entity.Course;
import com.example.ktRESTAPI.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByType(String id);

    List<Course> findByName(String nameValue);






}
