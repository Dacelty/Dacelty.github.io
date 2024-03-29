package com.example.ktRESTAPI.service;

import com.example.ktRESTAPI.entity.Course;
import com.example.ktRESTAPI.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourse() {
        return courseRepository.findAll();
    }


    public List<Course> getCourseByType(String id) {
        return courseRepository.findByType(id);
    }

    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    public List<Course> getCourseByName(String nameValue) {
        return courseRepository.findByName(nameValue);
    }

    public List<Course> getCourseByTopicName(String s) {
        return courseRepository.findByTopicName(s);
    }

    public List<Course> getCourseByNameAndTopicName(String s, String s1) {
        return courseRepository.findByNameAndTopicName(s, s1);
    }


}
