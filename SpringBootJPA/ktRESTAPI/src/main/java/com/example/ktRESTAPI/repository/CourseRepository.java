package com.example.ktRESTAPI.repository;

import com.example.ktRESTAPI.entity.Course;
import com.example.ktRESTAPI.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByType(String id);

    List<Course> findByName(String nameValue);

    @Query(nativeQuery = true,
            value = "select c.*,u.*,t.*\n" +
                    "from courses c\n" +
                    "inner join courses_topics cp on c.id=cp.course_id\n" +
                    "inner join topic t on cp.topics_id=t.id\n" +
                    "inner join user u\n" +
                    "where t.name=?1 group by c.id")
    List<Course> findByTopicName(String topicName);

    @Query(nativeQuery = true,
            value = "select c.*,u.*,t.*\n" +
                    "from courses c\n" +
                    "inner join courses_topics cp on c.id=cp.course_id\n" +
                    "inner join topic t on cp.topics_id=t.id\n" +
                    "inner join user u\n" +
                    "where c.name=?1 and t.name=?2 group by c.id")
    List<Course> findByNameAndTopicName(String s, String s1);
}
