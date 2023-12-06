package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.DeptRepository;
import com.example.demo.repository.MasterPositionRepository;
import com.example.demo.repository.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitionService
{
    @Autowired
    RequisitionRepository requisitionRepository;

    @Autowired
    MasterPositionRepository masterPositionRepository;

    @Autowired
    DeptRepository deptRepository;

    public List<Requisition> getAllRequisitions() {
        return requisitionRepository.findAll();
    }

    public List<Requisition> getRequisitionsByMasterPositionId(int masterPositionId) {
        return requisitionRepository.getRequisitionsByMasterPositionId(masterPositionId);
    }

    public Optional<Requisition> getRequisitionById(int id) {
        return requisitionRepository.findById(id);
    }

    public Requisition createRequisition(Requisition requisition) {

        MasterPosition masterPosition = requisition.getMasterPosition();

        MasterExperience masterExperience = requisition.getMasterExperience();

        Requisition newrequisition = new Requisition(masterPosition,masterExperience,requisition.getTotalRequisition(),requisition.getOpeningDate());

        Requisition savedRequisition = requisitionRepository.save(newrequisition);

        return savedRequisition;
    }




    public Requisition updateRequisition(int id, Requisition updatedRequisition) {
        Optional<Requisition> existingRequisition = requisitionRepository.findById(id);
        if (existingRequisition.isPresent()) {
            Requisition requisition = existingRequisition.get();
            requisition.setMasterPosition(updatedRequisition.getMasterPosition());
            requisition.setTotalRequisition(updatedRequisition.getTotalRequisition());
            requisition.setCarryForwardedRequisition(updatedRequisition.getCarryForwardedRequisition());
            requisition.setMasterExperience(updatedRequisition.getMasterExperience());
            requisition.setOpeningDate(updatedRequisition.getOpeningDate());
            requisition.setClosureDate(updatedRequisition.getClosureDate());
            requisition.setRevisedClosureDate(updatedRequisition.getRevisedClosureDate());
            requisition.setDaysToFillPosition(updatedRequisition.getDaysToFillPosition());
            requisition.setCreatedBy(updatedRequisition.getCreatedBy());
            requisition.setCreatedDate(updatedRequisition.getCreatedDate());
            requisition.setModifiedBy(updatedRequisition.getModifiedBy());
            requisition.setModifiedDate(updatedRequisition.getModifiedDate());
            // Update other properties as needed
            return requisitionRepository.save(requisition);
        } else {
            throw new IllegalArgumentException("Requisition not found with id: " + id);
        }
    }

    public List<RequisitionSummary> getRequisitionSummary() {
        List<RequisitionSummary> requisitionSummaries = requisitionRepository.getRequisitionSummary();

        return requisitionSummaries;
    }
    public void deleteRequisition(int id) {
        requisitionRepository.deleteById(id);
    }
}
