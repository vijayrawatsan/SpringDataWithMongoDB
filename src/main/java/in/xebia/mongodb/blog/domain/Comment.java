package in.xebia.mongodb.blog.domain;

import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document
public class Comment {
	
	@Id
	private String id;
	private String content;
	@org.springframework.data.mongodb.core.mapping.DBRef
	private User user;
	@org.springframework.data.mongodb.core.mapping.DBRef
	private Post post;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId();
	}
}
