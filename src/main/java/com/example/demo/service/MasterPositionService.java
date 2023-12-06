package com.example.demo.service;
import com.example.demo.entity.MasterPosition;
import com.example.demo.repository.MasterPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterPositionService
{
    @Autowired
    MasterPositionRepository masterPositionRepository;



    public List<MasterPosition> getAllMasterPositions() {
        return masterPositionRepository.findAll();
    }

    public MasterPosition getMasterPositionById(int id) {
        return masterPositionRepository.findById(id).get();
    }

    public MasterPosition createMasterPosition(MasterPosition masterPosition)
    {

        return masterPositionRepository.save(masterPosition);
    }

    public MasterPosition updateMasterPosition(int id, MasterPosition updatedMasterPosition) {
        Optional<MasterPosition> existingMasterPosition = masterPositionRepository.findById(id);
        if (existingMasterPosition.isPresent()) {
            MasterPosition masterPosition = existingMasterPosition.get();
            masterPosition.setDept(updatedMasterPosition.getDept());
            masterPosition.setName(updatedMasterPosition.getName());
            // Update other properties as needed
            return masterPositionRepository.save(masterPosition);
        } else {
            throw new IllegalArgumentException("MasterPosition not found with id: " + id);
        }
    }

    public void deleteMasterPosition(int id) {
        masterPositionRepository.deleteById(id);
    }

}
