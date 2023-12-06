package com.example.demo.entity;

public class RequisitionRequest {
    private int masterPositionId;
    private int masterExperienceId;
    private int totalRequisition;
    private String openingDate;


    public RequisitionRequest() {
    }

    public RequisitionRequest(int masterPositionId, int masterExperienceId, int totalRequisition, String openingDate) {
        this.masterPositionId = masterPositionId;
        this.masterExperienceId = masterExperienceId;
        this.totalRequisition = totalRequisition;
        this.openingDate = openingDate;
    }

    public int getMasterPositionId() {
        return masterPositionId;
    }

    public void setMasterPositionId(int masterPositionId) {
        this.masterPositionId = masterPositionId;
    }

    public int getMasterExperienceId() {
        return masterExperienceId;
    }

    public void setMasterExperienceId(int masterExperienceId) {
        this.masterExperienceId = masterExperienceId;
    }

    public int getTotalRequisition() {
        return totalRequisition;
    }

    public void setTotalRequisition(int totalRequisition) {
        this.totalRequisition = totalRequisition;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return "RequisitionRequest{" +
                "masterPositionId=" + masterPositionId +
                ", masterExperienceId=" + masterExperienceId +
                ", totalRequisition=" + totalRequisition +
                ", openingDate='" + openingDate +
                '}';
    }


    // ... (similar adjustments for other setters)
}

