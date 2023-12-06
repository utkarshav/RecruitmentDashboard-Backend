package com.example.demo.repository;

import com.example.demo.entity.Offers;
import com.example.demo.entity.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepository extends JpaRepository<Offers,Integer> {

    @Query(value = "SELECT o FROM Offers o JOIN RequisitionStatistics rs ON o.requisitionStatistics.id = rs.id WHERE rs.requisitionId.id = :requisitionId")
    List<Offers> findOffersByRequisitionId(@Param("requisitionId") int requisitionId);

}