package com.blog.FrameBlog.services.V2;

import com.blog.FrameBlog.models.User;
import com.blog.FrameBlog.models.V2.UserV2;

import java.util.List;

public interface UserServiceV2 {
	User save(final User user);
	
	UserV2 save(UserV2 user);
	
	List<UserV2> getAll();
	
	User get(Long id);
	
	User update(Long id, User user);
	
	UserV2 update(Long id, UserV2 user);
	
	void delete(Long id);
	
}
