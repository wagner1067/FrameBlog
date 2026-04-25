package com.blog.FrameBlog.repositories.V2;

import com.blog.FrameBlog.models.V2.AddressV2;
import com.blog.FrameBlog.models.V2.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryV2 extends JpaRepository<AddressV2, Long> {
	
	AddressV2 findByUsername(String login);
}
