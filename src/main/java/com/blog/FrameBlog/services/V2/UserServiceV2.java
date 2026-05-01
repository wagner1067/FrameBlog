package com.blog.FrameBlog.services.V2;

import com.blog.FrameBlog.models.V2.UserV2;

import java.util.List;

public interface UserServiceV2 {
	UserV2 save(final UserV2 user);
	
	List<UserV2> getAll();
	
	UserV2 get(Long id);
	
	UserV2 update(Long id, UserV2 user);
	
	void delete(Long id);
}
