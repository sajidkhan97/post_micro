package com.example.post_micro.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.post_micro.config.RestTemplateConfig;
import com.example.post_micro.entity.Posts;
import com.example.post_micro.payload.PostDto;
import com.example.post_micro.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository repo;
	
	@Autowired
	private RestTemplateConfig restTemplate;

	@Override
	public Posts savePost(Posts post) {
		// TODO Auto-generated method stub
		String postId = UUID.randomUUID().toString();
		post.setId(postId);
		return repo.save(post);
	}



	@Override
	public Posts getPostById(String postId) {
		Optional<Posts> findById = repo.findById(postId);
		Posts posts = findById.get();
		return posts;
	}



	@Override
	public List<Posts> getAllPosts() {
		List<Posts> findAll = repo.findAll();
		return findAll;
	}



	@Override
	public void deletePostById(String postId) {
		repo.deleteById(postId);
		
	}



	@Override
	public Posts updatePost(String postId, Posts updatePost) {
		Optional<Posts> findById = repo.findById(postId);
		Posts posts = findById.get();
		posts.setTitle(updatePost.getTitle());
		posts.setDescription(updatePost.getDescription());
		posts.setContent(updatePost.getContent());
		Posts save = repo.save(posts);
		return save;
	}



	@Override
	public PostDto getPostWithComments(String postId) {
		Posts post = repo.findById(postId).get();
		 
		 ArrayList list = restTemplate.getRestTemplate().getForObject("http://COMMENT-SERVICE/api/comment/"+postId, ArrayList.class); 
		
		 PostDto postDto = new PostDto();
		 postDto.setPostId(post.getId());
		 postDto.setTitle(post.getTitle());
		 postDto.setDescription(post.getDescription());
		 postDto.setContent(post.getContent());
		 postDto.setComments(list);
		 return postDto;




	

	

}
}
