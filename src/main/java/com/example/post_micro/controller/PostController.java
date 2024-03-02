package com.example.post_micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post_micro.entity.Posts;
import com.example.post_micro.payload.PostDto;
import com.example.post_micro.service.PostService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostService service;
	
	@PostMapping("/savePosts")
	public ResponseEntity<Posts> savePost(@RequestBody Posts post){
		
		Posts savedPost=service.savePost(post);
		return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
		
	}
	//http:localhost:8081/api/post/{postId}
	
	@GetMapping("/{postId}")
	public Posts getPostsById(@PathVariable String postId){
		Posts posts=service.getPostById(postId);
		return posts;
	}
	
	@GetMapping("/findAllPosts")
	public List<Posts> getAllPosts(){
		List<Posts> posts=service.getAllPosts();
		return posts;
	}
	
	@DeleteMapping("/{postId}")
	public String deletePostById(@PathVariable String postId) {
		service.deletePostById(postId);
		return "Post have been deleted successfully!!";
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<Posts> update(@PathVariable String postId,@RequestBody Posts updatePost){
		Posts post=service.updatePost(postId,updatePost);
		return new ResponseEntity<>(post,HttpStatus.OK);
		
	}
	
	@GetMapping("/{postId}/comments")
	@CircuitBreaker(name = "commentBreaker", fallbackMethod = "commentFallback")
	public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId){
		PostDto postDto=service.getPostWithComments(postId);
		return new ResponseEntity<>(postDto,HttpStatus.OK);
	}
	
	
	
	//to be called when the serice is down and this method must have same name as the circuit breaker fallback method with
	//same arguments as mentioned in the previous method that have circuit breaker annotation.
	public ResponseEntity<PostDto> commentFallback(String postId, Exception ex) {

        System.out.println("Fallback is executed because service is down : "+ ex.getMessage());

       ex.printStackTrace();

        PostDto dto = new PostDto();
        dto.setPostId("1234");
        dto.setTitle("Service Down");
        dto.setContent("Service Down");
        dto.setDescription("Service Down");
        //dto.setComments(Arrays.("Service Down"));
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
