package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.User;

import java.util.List;

public interface UserService {

	List<User> getAll();
	User get(String id );
	Boolean add(User user);
	Boolean delete(String id);
	Boolean edit(User user);
}
