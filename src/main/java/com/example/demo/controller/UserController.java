package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.entity.LoginActivity;
import com.example.demo.entity.LoginCheck;
import com.example.demo.service.LoginActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController 
{

	@Autowired
	UserService userService;

	@Autowired
	LoginActivityService loginActivityService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/logincheck")
	public User logincheck(@RequestBody LoginCheck lch) {

		User user = userService.getLogin(lch.getEmail(), lch.getPassword());
		if (user != null) {
			// Create a new LoginActivity entry
			LoginActivity loginActivity = new LoginActivity();
			loginActivity.setUser(user);
			loginActivity.setLoginTime(new Timestamp(System.currentTimeMillis()));
			loginActivity.setStatus(1);
			loginActivityService.save(loginActivity);
		}
		return user;
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUser()
	{
		return userService.getAll();
	}
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User u)
	{
		return userService.saveUser(u);
	}
	
	@GetMapping("/loginByEmail/{email}")
    public String getByEmail(@PathVariable String email) {
        return userService.getEmail(email);
    }
}
