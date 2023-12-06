package com.example.demo.repository;

import com.example.demo.entity.RequisitionStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionStatisticsRepository extends JpaRepository<RequisitionStatistics,Integer>
{
}
