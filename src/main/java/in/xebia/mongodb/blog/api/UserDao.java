package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends org.springframework.data.mongodb.repository.MongoRepository<User, String> {

}
