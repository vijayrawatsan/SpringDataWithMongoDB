package in.xebia.mongodb.blog.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import in.xebia.mongodb.blog.api.CommentDao;
import in.xebia.mongodb.blog.api.CommentService;
import in.xebia.mongodb.blog.domain.Comment;
import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDao commentDao;
	
	@Resource
	private MongoTemplate mongoTemplate;
	
	public List<Comment> getAll() {
		List<Comment> comments = commentDao.findAll();
		return comments;
	}

	public Comment get(String id) {
		Comment comment = commentDao.findOne(id);
		return comment;
	}

	public Boolean add(Comment comment) {
		try {
			if(comment.getId()==null || comment.getId().length()==0)
				comment.setId(UUID.randomUUID().toString());
		   commentDao.save(comment);
		   return true;
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}

	public List<Comment> get(Post post) {
		Query query = new Query(where("post.$id").is(post.getId()));
		List<Comment> comments = mongoTemplate.find(query, Comment.class);
		return comments;
	}
	
	public List<Comment> get(User user) {
		Query query = new Query(where("user.$id").is(user.getId()));
		List<Comment> comments = mongoTemplate.find(query, Comment.class);
		return comments;
	}
	
}
