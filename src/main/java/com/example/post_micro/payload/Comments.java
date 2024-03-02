package com.example.post_micro.payload;

public class Comments {
	
	private String commentId;
	private String name;
	private String email;
	private String body;
	private String postId;
	
	
	public Comments() {
		super();
	}
	public Comments(String commentId, String name, String email, String body, String postId) {
		super();
		this.commentId = commentId;
		this.name = name;
		this.email = email;
		this.body = body;
		this.postId = postId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	

}
