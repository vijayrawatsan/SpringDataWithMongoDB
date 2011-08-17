package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;

public interface PostService {

	List<Post> getAll();
	List<Post> getAll(User user);
	Post get(String id );
	Boolean add(Post post);
}
