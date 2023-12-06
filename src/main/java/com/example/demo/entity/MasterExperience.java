package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name="master_experience")
public class MasterExperience
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public MasterExperience() {
    }


    public MasterExperience(String name)
    {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
