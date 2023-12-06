package com.example.demo.repository;

import com.example.demo.entity.Requisition;
import com.example.demo.entity.RequisitionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition,Integer>
{

    @Query("SELECT NEW com.example.demo.entity.RequisitionSummary(r.masterPosition, SUM(r.totalRequisition)) " +
            "FROM Requisition r " +
            "GROUP BY r.masterPosition")
    List<RequisitionSummary> getRequisitionSummary();

    @Query("SELECT r FROM Requisition r WHERE r.masterPosition.id = :masterPositionId")
    List<Requisition> getRequisitionsByMasterPositionId(@Param("masterPositionId") int masterPositionId);



}
