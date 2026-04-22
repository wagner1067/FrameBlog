package com.blog.FrameBlog.controllers;

import com.blog.FrameBlog.models.User;
import com.blog.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	private @ResponseBody User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping(path = "/getAll")
	private @ResponseBody List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping(path = "/get")
	private @ResponseBody User get(@RequestParam final Long id) {
		return userService.get(id);
	}
	
	@PostMapping(path = "/update")
	private @ResponseBody User update(@RequestBody final Long id, @RequestBody final User user) {
		return userService.update(id, user);
	}
	
	@DeleteMapping(path = "/delete")
	private ResponseEntity<?> delete(@RequestParam final Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path = "/")
	public @ResponseBody String authenticate() {
		return "Hello World!";
	}
}
