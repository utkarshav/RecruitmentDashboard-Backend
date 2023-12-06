package com.example.demo.entity;

import javax.persistence.*;


import java.util.Optional;

@Entity
@Table(name="master_position")
public class MasterPosition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name="dept_id")
    @ManyToOne
    private Dept dept;

    @Column
    private String name;

    public MasterPosition() {
    }

    public MasterPosition( Dept dept, String name) {
        this.dept = dept;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
