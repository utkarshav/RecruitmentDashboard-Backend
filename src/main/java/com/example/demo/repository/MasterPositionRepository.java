package com.example.demo.repository;

import com.example.demo.entity.MasterPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterPositionRepository extends JpaRepository<MasterPosition, Integer>
{
    MasterPosition findByIdAndDept_Id(int masterPositionId, int deptId);
}

