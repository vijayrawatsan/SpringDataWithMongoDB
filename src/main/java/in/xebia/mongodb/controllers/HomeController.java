package in.xebia.mongodb.controllers;

import in.xebia.mongodb.blog.api.CommentService;
import in.xebia.mongodb.blog.api.PostService;
import in.xebia.mongodb.blog.api.UserService;
import in.xebia.mongodb.blog.domain.Comment;
import in.xebia.mongodb.blog.domain.Post;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	@Resource
	private UserService userService;
	
	@Resource
	private PostService postService;
	
	@Resource
	private CommentService commentService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public @ResponseBody List<Post> getAllPosts() {
		List<Post> posts = postService.getAll();
		return posts;
	}
	
	@RequestMapping(value="/posts/user", method=RequestMethod.POST)
	public @ResponseBody List<Post> getAllPostsByUser(@RequestBody User user) {
		return postService.getAll(user);
	}
	
	@RequestMapping(value="/comments", method=RequestMethod.GET)
	public @ResponseBody List<Comment> getAllComments() {
		return commentService.getAll();
	}
	
	@RequestMapping(value="/comments/post", method=RequestMethod.POST)
	public @ResponseBody List<Comment> getAllCommentsByPost(@RequestBody Post post) {
		return commentService.get(post);
	}

	@RequestMapping(value="/comments/user", method=RequestMethod.POST)
	public @ResponseBody List<Comment> getAllCommentsByUser(@RequestBody User user) {
		return commentService.get(user);
	}
	
	@RequestMapping(value="/add/user", method=RequestMethod.POST)
	public @ResponseBody Boolean addUser(@RequestBody User user) {
		System.out.println(user.toString());
		if(userService.add(user))
			return true;
		else
			return false;
	}
	
	@RequestMapping(value="/add/post", method=RequestMethod.POST)
	public @ResponseBody Boolean addPost(@RequestBody Post post) {
		if(postService.add(post))
			return true;
		else
			return false;
	}
	
	@RequestMapping(value="/add/comment", method=RequestMethod.POST)
	public @ResponseBody Boolean addComment(@RequestBody Comment comment) {
		if(commentService.add(comment))
			return true;
		else
			return false;
	}
}

