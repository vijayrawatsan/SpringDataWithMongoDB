package in.xebia.mongodb.blog.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import in.xebia.mongodb.blog.api.PostDao;
import in.xebia.mongodb.blog.api.PostService;
import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Resource
	private PostDao postDao;
	
	@Resource
	private MongoTemplate mongoTemplate;
	
	public List<Post> getAll() {
		List<Post> posts = postDao.findAll();
		return posts;
	}

	public Post get(String id) {
		Post post = postDao.findOne(id);
		return post;
	}
	
	public Boolean add(Post post) {

		try {
			if(post.getId()==null || post.getId().length()==0)
				post.setId(UUID.randomUUID().toString());
			   postDao.save(post);
			   return true;
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}

	public List<Post> getAll(User user) {
		Query query = new Query(where("user.$id").is(user.getId()));
		List<Post> posts = mongoTemplate.find(query, Post.class);
		return posts;
	}

}
