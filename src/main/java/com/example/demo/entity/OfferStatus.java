package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="offer_status")
public class OfferStatus
{
    @Id
    private int id;

    @Column
    private String name;

    public OfferStatus()
    {

    }


    public OfferStatus(String name) {
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
