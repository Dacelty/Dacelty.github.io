package com.example.ktRESTAPI.repository;

import com.example.ktRESTAPI.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
