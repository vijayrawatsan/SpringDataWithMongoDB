package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.Post;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PostDao extends org.springframework.data.mongodb.repository.MongoRepository<Post, String>{
	
}
