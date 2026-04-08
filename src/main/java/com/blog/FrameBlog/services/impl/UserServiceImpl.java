package com.blog.FrameBlog.services.impl;

import com.blog.FrameBlog.models.User;
import com.blog.FrameBlog.repositories.UserRepository;
import com.blog.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user){
        User existingUser = userRepository.findByUsername(user.getName());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("User already exists");
        }
        User entity = new User(user.getUserId(), user.getName(),user.getEmail(),user.getPassword(),user.getRole());
        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(),newUser.getEmail(), newUser.getPassword(),newUser.getRole());
    }

}
