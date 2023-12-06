package com.example.demo.entity;

public class RequisitionSummary {

    private MasterPosition masterPosition;
    private long totalRequisitions;

    // Default constructor for Hibernate
    public RequisitionSummary() {
    }

    public RequisitionSummary(MasterPosition masterPosition, Long totalRequisitions) {
        this.masterPosition = masterPosition;
        this.totalRequisitions = totalRequisitions;
    }


    public MasterPosition getMasterPosition() {
        return masterPosition;
    }

    public void setMasterPositionId(MasterPosition masterPosition) {
        this.masterPosition = masterPosition;
    }

    public long getTotalRequisition() {
        return totalRequisitions;
    }

    public void setTotalRequisition(long totalRequisitions) {
        this.totalRequisitions = totalRequisitions;
    }
}
