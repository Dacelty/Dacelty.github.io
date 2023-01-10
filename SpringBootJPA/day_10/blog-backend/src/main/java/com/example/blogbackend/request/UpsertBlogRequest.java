package com.example.blogbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertBlogRequest {
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private Boolean status;
    private List<Integer> categoryIds; // danh sách id của category
}
