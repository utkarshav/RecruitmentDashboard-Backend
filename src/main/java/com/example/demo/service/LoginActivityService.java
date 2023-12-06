package com.example.demo.service;

import com.example.demo.entity.LoginActivity;
import com.example.demo.repository.LoginActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginActivityService
{
    @Autowired
    LoginActivityRepository loginActivityRepository;

    public List<LoginActivity> getAllLogingActivity()
    {
        return loginActivityRepository.findAll();
    }

    public LoginActivity save(LoginActivity loginActivity)
    {
        return loginActivityRepository.save(loginActivity);
    }
}
