package com.example.demo.repository;

import com.example.demo.entity.MasterExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterExperienceRepository extends JpaRepository<MasterExperience,Integer>
{
}
