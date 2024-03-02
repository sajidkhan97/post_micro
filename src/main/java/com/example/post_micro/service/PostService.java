package com.example.post_micro.service;

import java.util.List;

import com.example.post_micro.entity.Posts;
import com.example.post_micro.payload.PostDto;

public interface PostService {

	Posts savePost(Posts post);

	

	Posts getPostById(String postId);



	List<Posts> getAllPosts();



	



	void deletePostById(String postId);



	Posts updatePost(String postId, Posts UpdatePost);



	PostDto getPostWithComments(String postId);

}