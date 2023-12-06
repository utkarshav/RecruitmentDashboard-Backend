package com.example.demo.entity;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="requisition")
public class Requisition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "master_position_id")
    private MasterPosition masterPosition;


    @Column(name = "total_requisition")
    private int totalRequisition;

    @Column(name = "carry_forwarded_requisition")
    private int carryForwardedRequisition;

    @ManyToOne
    @JoinColumn(name = "master_experience_id")
    private MasterExperience masterExperience;

    @Column(name = "opening_date")
    @Temporal(TemporalType.DATE)
    private Date openingDate;

    @Column(name = "closure_date")
    @Temporal(TemporalType.DATE)
    private Date closureDate;

    @Column(name = "revised_closure_date")
    @Temporal(TemporalType.DATE)
    private Date revisedClosureDate;

    @Column(name = "days_to_fill_position")
    private int daysToFillPosition;

    @Transient
    @Formula("DATEDIFF(CURDATE(), opening_date)")
    private Integer openSince;



    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private User modifiedBy;

    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;


    public Requisition() {
    }

    public Requisition(MasterPosition masterPosition, int totalRequisition, int carryForwardedRequisition, MasterExperience masterExperience, Date openingDate, Date closureDate, Date revisedClosureDate, int daysToFillPosition, User createdBy, Date createdDate, User modifiedBy, Date modifiedDate) {
        this.masterPosition = masterPosition;
        this.totalRequisition = totalRequisition;
        this.carryForwardedRequisition = carryForwardedRequisition;
        this.masterExperience = masterExperience;
        this.openingDate = openingDate;
        this.closureDate = closureDate;
        this.revisedClosureDate = revisedClosureDate;
        this.daysToFillPosition = daysToFillPosition;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Requisition(MasterPosition masterPosition,MasterExperience masterExperience , int totalRequisition,Date openingDate)
    {
        this.masterPosition = masterPosition;
        this.masterExperience = masterExperience;
        this.totalRequisition = totalRequisition;
        this.openingDate = openingDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MasterPosition getMasterPosition() {
        return masterPosition;
    }

    public void setMasterPosition(MasterPosition masterPosition) {
        this.masterPosition = masterPosition;
    }

    public int getTotalRequisition() {
        return totalRequisition;
    }

    public void setTotalRequisition(int totalRequisition) {
        this.totalRequisition = totalRequisition;
    }

    public int getCarryForwardedRequisition() {
        return carryForwardedRequisition;
    }

    public void setCarryForwardedRequisition(int carryForwardedRequisition) {
        this.carryForwardedRequisition = carryForwardedRequisition;
    }

    public MasterExperience getMasterExperience() {
        return masterExperience;
    }

    public void setMasterExperience(MasterExperience masterExperience) {
        this.masterExperience = masterExperience;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(Date closureDate) {
        this.closureDate = closureDate;
    }

    public Date getRevisedClosureDate() {
        return revisedClosureDate;
    }

    public void setRevisedClosureDate(Date revisedClosureDate) {
        this.revisedClosureDate = revisedClosureDate;
    }

    public int getDaysToFillPosition() {
        return daysToFillPosition;
    }

    public void setDaysToFillPosition(int daysToFillPosition) {
        this.daysToFillPosition = daysToFillPosition;
    }

    public Integer getOpenSince() {
        return openSince;
    }

    public void setOpenSince(Integer openSince) {
        this.openSince = openSince;
    }
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "id=" + id +
                ", masterPosition=" + masterPosition +
                ", masterExperience=" + masterExperience +
                ", totalRequisition=" + totalRequisition +
                ", openingDate=" + openingDate +
                '}';
    }

}
