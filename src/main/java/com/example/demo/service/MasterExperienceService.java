package com.example.demo.service;
import com.example.demo.entity.MasterExperience;
import com.example.demo.repository.MasterExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterExperienceService {
    @Autowired
    MasterExperienceRepository masterExperienceRepository;

    public List<MasterExperience> getAllMasterExperiences() {
        return masterExperienceRepository.findAll();
    }


    public MasterExperience getMasterExperienceById(int id) {
        return masterExperienceRepository.findById(id).get();
    }

    public MasterExperience createMasterExperience(MasterExperience masterExperience) {
        return masterExperienceRepository.save(masterExperience);
    }

    public MasterExperience updateMasterExperience(int id, MasterExperience updatedMasterExperience) {
        Optional<MasterExperience> existingMasterExperience = masterExperienceRepository.findById(id);
        if (existingMasterExperience.isPresent()) {
            MasterExperience masterExperience = existingMasterExperience.get();
            masterExperience.setName(updatedMasterExperience.getName());
            return masterExperienceRepository.save(masterExperience);
        } else {
            throw new IllegalArgumentException("MasterExperience not found with id: " + id);
        }
    }

    public void deleteMasterExperience(int id) {
        masterExperienceRepository.deleteById(id);
    }


}
