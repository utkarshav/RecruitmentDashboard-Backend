package com.example.demo.entity;



import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "requisition_statistics_id")
    private RequisitionStatistics requisitionStatistics;

    @Column(name = "offer_date")
    private Date offerDate;

    @Column(name = "days_taken_to_offer")
    private Integer daysTakenToOffer;

    @Column(name = "days_taken_to_join")
    private Integer daysTakenToJoin;

    @Column(name = "delay")
    private Integer delay;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OfferStatus status;


    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "created_by")
    private Integer createdBy = 0;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy = 0;

    @Column(name = "modified_date")
    private Date modifiedDate;



    public Offers() {

    }

    public Offers(RequisitionStatistics requisitionStatisticsId, Date offerDate, Integer daysTakenToOffer, Integer daysTakenToJoin, Integer delay, OfferStatus statusId, Date joiningDate, Integer createdBy, Date createdDate, Integer modifiedBy, Date modifiedDate) {
        this.requisitionStatistics = requisitionStatisticsId;
        this.offerDate = offerDate;
        this.daysTakenToOffer = daysTakenToOffer;
        this.daysTakenToJoin = daysTakenToJoin;
        this.delay = delay;
        this.status = statusId;
        this.joiningDate = joiningDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RequisitionStatistics getRequisitionStatistics() {
        return requisitionStatistics;
    }

    public void setRequisitionStatistics(RequisitionStatistics requisitionStatisticsId) {
        this.requisitionStatistics = requisitionStatisticsId;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public Integer getDaysTakenToOffer() {
        return daysTakenToOffer;
    }

    public void setDaysTakenToOffer(Integer daysTakenToOffer) {
        this.daysTakenToOffer = daysTakenToOffer;
    }

    public Integer getDaysTakenToJoin() {
        return daysTakenToJoin;
    }

    public void setDaysTakenToJoin(Integer daysTakenToJoin) {
        this.daysTakenToJoin = daysTakenToJoin;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public OfferStatus getStatusId() {
        return status;
    }

    public void setStatusId(OfferStatus statusId) {
        this.status = statusId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

