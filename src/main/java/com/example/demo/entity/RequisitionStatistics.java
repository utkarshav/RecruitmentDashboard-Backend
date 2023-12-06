package com.example.demo.entity;


import javax.persistence.*;


import java.util.Date;

@Entity
@Table(name = "requisition_statistics")
public class RequisitionStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisitionId;

    @Column(name = "offered", nullable = false)
    private Integer offered = 0;

    @Column(name = "offer_backout", nullable = false)
    private Integer offerBackout = 0;

    @Column(name = "joined", nullable = false)
    private Integer joined =0 ;

    @Column(name = "offer_in_pipeline", nullable = false)
    private Integer offerInPipeline =0;

    @Column(name = "created_by")
    private Integer createdBy ;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy ;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "requisition_status_id")
    private int requisitionStatusId;

    public RequisitionStatistics() {
    }

    public RequisitionStatistics(Requisition requisitionId, Integer offered, Integer offerBackout, Integer joined, Integer offerInPipeline, Integer createdBy, Date createdDate, Integer modifiedBy, Date modifiedDate, int requisitionStatusId) {
        this.requisitionId = requisitionId;
        this.offered = offered;
        this.offerBackout = offerBackout;
        this.joined = joined;
        this.offerInPipeline = offerInPipeline;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.requisitionStatusId = requisitionStatusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Requisition getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Requisition requisitionId) {
        this.requisitionId = requisitionId;
    }

    public Integer getOffered() {
        return offered;
    }

    public void setOffered(Integer offered) {
        this.offered = offered;
    }

    public Integer getOfferBackout() {
        return offerBackout;
    }

    public void setOfferBackout(Integer offerBackout) {
        this.offerBackout = offerBackout;
    }

    public Integer getJoined() {
        return joined;
    }

    public void setJoined(Integer joined) {
        this.joined = joined;
    }

    public Integer getOfferInPipeline() {
        return offerInPipeline;
    }

    public void setOfferInPipeline(Integer offerInPipeline) {
        this.offerInPipeline = offerInPipeline;
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

    public int getRequisitionStatusId() {
        return requisitionStatusId;
    }

    public void setRequisitionStatusId(int requisitionStatusId) {
        this.requisitionStatusId = requisitionStatusId;
    }
}

