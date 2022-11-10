package vn.techmaster.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.course.entity.Course;
import vn.techmaster.course.repository.TopicRepository;
import vn.techmaster.course.repository.UserRepository;
import vn.techmaster.course.request.UpsertCourseRequest;
import vn.techmaster.course.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("")
    public ResponseEntity<?> getCourses() {
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("") // 201
    public ResponseEntity<?> createCourse(@RequestBody UpsertCourseRequest request) {
        Course course = courseService.createCourse(request);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id) {
        return courseService.updateCourse(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse() {
        return null;
    }

    @PostMapping("{id}/upload-thumbnail")
    public ResponseEntity<?> uploadFile() {
        return null;
    }
}
