package com.blog.FrameBlog.services;

import com.blog.FrameBlog.models.Tag;

import java.util.List;

public interface TagService {
	
	Tag save(final Tag tag);
	
	List<Tag> getAll();
	
	Tag get(final Long id);
	
	Tag update(final Long id, final Tag tag);
	
	void delete(final Long id);
}