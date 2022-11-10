package vn.techmaster.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.techmaster.course.entity.Course;
import vn.techmaster.course.entity.User;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.repository.CourseRepository;
import vn.techmaster.course.repository.TopicRepository;
import vn.techmaster.course.repository.UserRepository;
import vn.techmaster.course.request.UpsertCourseRequest;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Course not found");
        });
    }


    public Course createCourse(UpsertCourseRequest request) {
        return null;
    }

    public ResponseEntity<?> updateCourse(Integer id) {

    }
}
