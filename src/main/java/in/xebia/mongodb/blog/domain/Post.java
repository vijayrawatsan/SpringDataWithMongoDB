package in.xebia.mongodb.blog.domain;

import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document
public class Post {

	@Id
	private String id;
	private String subject;
	private String content;
	@org.springframework.data.mongodb.core.mapping.DBRef
	private User user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId();
	}
}
