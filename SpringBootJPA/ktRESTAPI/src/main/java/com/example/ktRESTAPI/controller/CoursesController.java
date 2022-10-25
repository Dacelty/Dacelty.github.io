package com.example.ktRESTAPI.controller;

import com.example.ktRESTAPI.entity.Course;
import com.example.ktRESTAPI.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourse() {
        return courseService.getCourse();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/courses/online")
    public List<Course> getCourseByTypeOnline(){
        String id = "online";
        return courseService.getCourseByType(id);
    }

    @GetMapping("/courses/onlab")
    public List<Course> getCourseByTypeOnLab(){
        String id = "onlab";
        return courseService.getCourseByType(id);
    }


    @GetMapping("/courses/search")
    @ResponseBody
    public List<Course> searchCourse(@RequestParam Optional<String> name,@RequestParam Optional<String> topic) {
        if(name.isPresent() && topic.isEmpty()) {
            return courseService.getCourseByName(name.get());
        } else if (topic.isPresent() && name.isEmpty()) {
            return courseService.getCourseByTopicName(topic.get());
        } else if (name.isPresent() && topic.isPresent()) {
            return courseService.getCourseByNameAndTopicName(name.get(),topic.get());
        }
        return courseService.getCourse();
    }




}
