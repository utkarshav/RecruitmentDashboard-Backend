package com.example.demo.entity;

public class LoginCheck
{
    private String email;
    private String password;

    public LoginCheck()
    {

    }

    public LoginCheck(String email , String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
