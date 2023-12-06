package com.example.demo.entity;
import com.example.demo.entity.User;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="login_activity")
public class LoginActivity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private User user;

    @Column(name = "login_time", columnDefinition = "DATETIME")
    private Timestamp loginTime;

    @Column(name="status")
    private  int status;

    public LoginActivity()
    {
    }

    public LoginActivity(int id, User user, Timestamp loginTime,int status) {
        this.id = id;
        this.user = user;
        this.loginTime = loginTime;
        this.status=status;
    }

    public int getLoginId() {
        return id;
    }

    public void setLoginId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
