package in.xebia.mongodb.blog.impl;

import in.xebia.mongodb.blog.api.PostDao;
import in.xebia.mongodb.blog.api.UserDao;
import in.xebia.mongodb.blog.domain.Comment;
import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class PopulatorService {
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private PostDao postDao;
	
	@Resource(name="mongoTemplate")
	private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;
	
	void init() throws JsonParseException, JsonMappingException, IOException{
		initUsers();
		initPosts();
		initComments();
	}

	private void initComments() throws JsonParseException, JsonMappingException, IOException {

		  mongoTemplate.dropCollection("comment");
		 
		  List<Post> posts = postDao.findAll();
		  Comment c = new Comment();
		  c.setId(UUID.randomUUID().toString());
		  c.setContent("Demo Comment 1");
		  c.setPost(posts.get(0));
		  c.setUser(posts.get(0).getUser());
		  mongoTemplate.insert(c, "comment");
		  
		  c = new Comment();
		  c.setId(UUID.randomUUID().toString());
		  c.setContent("Demo Comment 2");
		  c.setPost(posts.get(0));
		  c.setUser(posts.get(0).getUser());
		  mongoTemplate.insert(c, "comment");
		  
		  c = new Comment();
		  c.setId(UUID.randomUUID().toString());
		  c.setContent("Demo Comment 3");
		  c.setPost(posts.get(1));
		  c.setUser(posts.get(1).getUser());
		  mongoTemplate.insert(c, "comment");
		  
		  c = new Comment();
		  c.setId(UUID.randomUUID().toString());
		  c.setContent("Demo Comment 4");
		  c.setPost(posts.get(2));
		  c.setUser(posts.get(2).getUser());
		  mongoTemplate.insert(c, "comment");
		  
	}

	private void initPosts() throws JsonParseException, JsonMappingException, IOException {
		
		  mongoTemplate.dropCollection("post");
		  List<User> users = userDao.findAll();
			  
		  Post p = new Post();
		  p.setContent("Sample Content 1");
		  p.setSubject("Demo Subject 1");
		  p.setId(UUID.randomUUID().toString());
		  p.setUser(users.get(0));
		  mongoTemplate.insert(p, "post");
		  
		  System.out.println("inserted 1 post");
		  p = new Post();
		  p.setId(UUID.randomUUID().toString());
		  p.setContent("Sample Content 2");
		  p.setSubject("Demo Subject 2");
		  p.setUser(users.get(0));
		  mongoTemplate.insert(p, "post");
		  p = new Post();
		  p.setId(UUID.randomUUID().toString());
		  p.setContent("Sample Content 3");
		  p.setSubject("Demo Subject 3");
		  p.setUser(users.get(1));
		  mongoTemplate.insert(p, "post");
		
	}

	private void initUsers() {

		mongoTemplate.dropCollection("user");
		  User u = new User();
		  u.setUserName("vijay");
		  u.setId(UUID.randomUUID().toString());
		  u.setPassword("password");
		  mongoTemplate.insert(u, "user");
		  u = new User();
		  u.setId(UUID.randomUUID().toString());
		  u.setUserName("notVijay");
		  u.setPassword("newPaasword");
		  mongoTemplate.insert(u, "user");
	}
}
