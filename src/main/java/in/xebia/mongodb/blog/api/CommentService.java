package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.Comment;
import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;

public interface CommentService {

	List<Comment> getAll();
	Comment get(String id );
	Boolean add(Comment comment);
	List<Comment> get(Post post);
	List<Comment> get(User user);
}
