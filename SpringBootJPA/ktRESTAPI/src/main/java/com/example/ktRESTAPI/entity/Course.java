package com.example.ktRESTAPI.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
//    id : Interger; // Id khóa học
//    name : String; // Tên khóa học
//    description : String; // Mô tả khóa học
//    type : String; // Hình thức học (chỉ có 2 hình thức online/onlab)
//    thumbnail : String; // Ảnh khóa học
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "courses_topics",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "topics_id"))
    private Set<Topic> topics = new LinkedHashSet<>();

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false, unique = true)
//    private User user;
//
//    @ManyToMany
//    @JoinTable(name = "courses_topics",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "topics_id"))
//    private Set<Topic> topics = new LinkedHashSet<>();



}
