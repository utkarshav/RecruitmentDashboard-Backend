package com.example.demo.repository;

import com.example.demo.entity.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferStatusRepository extends JpaRepository<OfferStatus,Integer>
{

}
