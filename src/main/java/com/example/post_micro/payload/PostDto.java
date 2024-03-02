package com.example.post_micro.payload;

import java.util.List;

import lombok.Data;

@Data
public class PostDto {
	private String postId;
	private String title;
	private String description;
	private String content;
	private List<Comments> comments;
	
	
	
	public PostDto() {
		super();
	}



	public PostDto(String postId, String title, String description, String content, List<Comments> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.comments = comments;
	}



	public String getPostId() {
		return postId;
	}



	public void setPostId(String postId) {
		this.postId = postId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public List<Comments> getComments() {
		return comments;
	}



	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	
	
	
	

}
