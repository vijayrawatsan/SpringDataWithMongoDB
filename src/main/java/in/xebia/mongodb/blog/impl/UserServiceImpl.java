package in.xebia.mongodb.blog.impl;

import in.xebia.mongodb.blog.api.UserDao;
import in.xebia.mongodb.blog.api.UserService;
import in.xebia.mongodb.blog.domain.User;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	public List<User> getAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	public User get(String id) {
		User user = userDao.findOne(id);
		return user;
	}

	public Boolean add(User user) {
		
		try {
			if(user.getId()==null || user.getId().length()==0)
				user.setId(UUID.randomUUID().toString());
			
			userDao.save(user);
			return true;
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}

	public Boolean delete(String id) {
		try {
		    userDao.delete(userDao.findOne(id));
            return true;
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}

	public Boolean edit(User user) {
		try {
		    User existingUser = userDao.findOne(user.getId());
		    existingUser.setUserName(user.getUserName());
		    existingUser.setPassword(user.getPassword());
		    userDao.save(existingUser);
		    return true;
		    
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}

}
