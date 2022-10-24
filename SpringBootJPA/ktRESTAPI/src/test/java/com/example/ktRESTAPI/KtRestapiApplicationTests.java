package com.example.ktRESTAPI;

import com.example.ktRESTAPI.entity.Course;
import com.example.ktRESTAPI.entity.Topic;
import com.example.ktRESTAPI.entity.User;
import com.example.ktRESTAPI.repository.CourseRepository;
import com.example.ktRESTAPI.repository.TopicRepository;
import com.example.ktRESTAPI.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class KtRestapiApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicRepository topicRepository;

	@Test
	@Rollback(value = false)
	void save_user() {
		User user = User.builder()
				.name("Nguyễn Văn A")
				.email("a@gmail.com")
				.phone("0988887777")
				.build();

		User user1 = User.builder()
				.name("Trần Văn B")
				.email("b@gmail.com")
				.phone("0988886666")
				.build();

		User user2 = User.builder()
				.name("Ngô Thị C")
				.email("c@gmail.com")
				.phone("0988885555")
				.build();

		userRepository.saveAll(List.of(user, user1, user2));
	}

	@Test
	@Rollback(value = false)
	void save_course(){
		List<User> list = userRepository.findAll();
		List<Topic> topicList = topicRepository.findAll();

		Random rd = new Random();
		Faker faker = new Faker();

		for (int i = 0; i < 10; i++) {
			User rduser = list.get(rd.nextInt(list.size()));

			Set<Topic> myList = new HashSet<>();
			for (int j = 0; j < 3; j++) {
				Topic rdtopic = topicList.get(rd.nextInt(topicList.size()));
				myList.add(rdtopic);
			}
			Course course = Course.builder()
					.name(faker.name().fullName())
					.description(faker.lorem().sentence(5))
					.type(rd.nextInt(2)==1?"online":"onlab")
					.user(rduser)
					.topics(myList)
					.build();
			courseRepository.save(course);
		}
	}

	@Test
	@Rollback(value = false)
	void save_topic() {
		Topic topic1 = Topic.builder()
				.name("Java")
				.build();

		Topic topic2 = Topic.builder()
				.name("PHP")
				.build();

		Topic topic3 = Topic.builder()
				.name("Rust")
				.build();

		Topic topic4 = Topic.builder()
				.name("KHonline")
				.build();

		Topic topic5 = Topic.builder()
				.name("KHonlab")
				.build();

		topicRepository.saveAll(List.of(topic1, topic2, topic3, topic4, topic5));
	}



}
