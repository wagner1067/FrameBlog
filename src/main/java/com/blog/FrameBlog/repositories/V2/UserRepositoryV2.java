package com.blog.FrameBlog.repositories.V2;

import com.blog.FrameBlog.models.V2.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryV2 extends JpaRepository<UserV2, Long> {
	
	UserV2 findByUsername(String login);
}