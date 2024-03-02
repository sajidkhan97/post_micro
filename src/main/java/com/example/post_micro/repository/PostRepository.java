package com.example.post_micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.post_micro.entity.Posts;

public interface PostRepository extends JpaRepository<Posts, String> {

}
