package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository urepo;
	
	public List<User> getAll()
	{
		return urepo.findAll();
	}
	
	public User saveUser(User u)
	{
		return urepo.save(u);
	}
	
	public String getEmail(String email)
	{
		return urepo.findByEmail(email);
	}

	public User getLogin(String email,String password)
	{
		User l;
		Optional<User> ol =urepo.getLogin(email, password);
		try
		{
			l = ol.get();
		}
		catch(Exception e)
		{
			l = null;
		}
		return l;
	}

}
