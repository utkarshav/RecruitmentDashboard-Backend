package com.example.demo.entity;

public class MasterPositionRequest
{
    private int id;
    private String name;

    public MasterPositionRequest() {
    }

    public MasterPositionRequest(String name) {
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

