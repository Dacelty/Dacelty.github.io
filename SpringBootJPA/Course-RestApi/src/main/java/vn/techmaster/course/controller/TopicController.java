package vn.techmaster.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
public class TopicController {
    @GetMapping("")
    public ResponseEntity<?> getTopics() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTopicById() {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createTopic() {
        return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTopic() {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTopic() {
        return null;
    }
}
