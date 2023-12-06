package com.example.demo.entity;

import javax.persistence.*;

import java.util.Date;


@Entity
    @Table(name = "panel")
    public class Panel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "master_position_id", nullable = false)
        private int masterPositionId;

        @Column(name = "name", length = 45)
        private String name;

        @Column(name = "interviews_conducted")
        private Integer interviewsConducted;

        @Column(name = "Date", nullable = false)
        private Date date;



        public Panel() {
        }

        public Panel(int masterPositionId, String name, Integer interviewsConducted, Date date) {
            this.masterPositionId = masterPositionId;
            this.name = name;
            this.interviewsConducted = interviewsConducted;
            this.date = date;
        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMasterPositionId() {
            return masterPositionId;
        }

        public void setMasterPositionId(int masterPositionId) {
            this.masterPositionId = masterPositionId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getInterviewsConducted() {
            return interviewsConducted;
        }

        public void setInterviewsConducted(Integer interviewsConducted) {
            this.interviewsConducted = interviewsConducted;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

