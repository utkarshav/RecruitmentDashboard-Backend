package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name="requisition_status")
public class RequisitionStatus
{
    @Id
    private int id;

    @Column
    private String name;

    public RequisitionStatus() {
    }

    public RequisitionStatus(String name) {
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
