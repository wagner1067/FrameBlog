package com.blog.FrameBlog.services;

import com.blog.FrameBlog.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User get(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
