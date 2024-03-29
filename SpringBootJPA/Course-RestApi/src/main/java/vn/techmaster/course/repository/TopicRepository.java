package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.course.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
}