package in.xebia.mongodb.blog.api;

import in.xebia.mongodb.blog.domain.Comment;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommentDao extends org.springframework.data.mongodb.repository.MongoRepository<Comment, String>{

}
