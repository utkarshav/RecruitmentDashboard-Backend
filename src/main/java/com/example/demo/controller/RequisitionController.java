package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.DeptRepository;
import com.example.demo.repository.MasterExperienceRepository;
import com.example.demo.repository.MasterPositionRepository;
import com.example.demo.service.DeptService;
import com.example.demo.service.MasterExperienceService;
import com.example.demo.service.MasterPositionService;
import com.example.demo.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/requisitions")
public class RequisitionController {

    @Autowired
    private RequisitionService requisitionService;

    @Autowired
    DeptService deptService;

    @Autowired
    DeptRepository deptRepository;

    @Autowired
    MasterPositionService masterPositionService;

    @Autowired
    MasterExperienceService masterExperienceService;

    @Autowired
    MasterPositionRepository masterPositionRepository;

    @Autowired
    MasterExperienceRepository masterExperienceRepository;

    @GetMapping("/allRequisitions")
    public List<Requisition> getAllRequisitions() {
        return requisitionService.getAllRequisitions();
    }

    @GetMapping("/byMasterPosition/{masterPositionId}")
    public List<Requisition> getRequisitionsByMasterPositionId(@PathVariable int masterPositionId) {
        return requisitionService.getRequisitionsByMasterPositionId(masterPositionId);
    }

    @GetMapping("/getAllRequisitionSummary")
    public List<RequisitionSummary> getAllRequisitionSummary(){
        return  requisitionService.getRequisitionSummary();
    }


    @GetMapping("getRequisitionById/{id}")
    public Optional<Requisition> getRequisitionById(@PathVariable int id) {
        return requisitionService.getRequisitionById(id);
    }

    @PostMapping("/saveRequisition")
    public ResponseEntity<Requisition> saveRequisition(@RequestBody RequisitionRequest requisitionRequest) {
           System.out.println("request payload" +requisitionRequest);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date parsedDate = dateFormat.parse(requisitionRequest.getOpeningDate());

            // Step 1: Fetch the existing MasterPosition from the database based on its ID
            Optional<MasterPosition> optionalExistingMasterPosition = masterPositionRepository.findById(requisitionRequest.getMasterPositionId());

            if (optionalExistingMasterPosition.isEmpty()) {
                // Handle the case where MasterPosition with the given ID is not found
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            MasterPosition existingMasterPosition = optionalExistingMasterPosition.get();

            // Check if the department already exists
            Dept existingDept = existingMasterPosition.getDept();
            Dept savedDept = (existingDept != null) ? existingDept : deptRepository.save(new Dept(existingMasterPosition.getDept().getName()));

            // Step 2: Update the existing MasterPosition with the new department
            existingMasterPosition.setDept(savedDept);
            MasterPosition savedMasterPosition = masterPositionRepository.save(existingMasterPosition);

            // Step 3: Fetch the existing MasterExperience from the database based on its ID
            Optional<MasterExperience> optionalExistingMasterExperience = masterExperienceRepository.findById(requisitionRequest.getMasterExperienceId());

            if (optionalExistingMasterExperience.isEmpty()) {
                // Handle the case where MasterExperience with the given ID is not found
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            MasterExperience existingMasterExperience = optionalExistingMasterExperience.get();

            // Step 4: Save the Requisition with the updated MasterPosition and existing MasterExperience
            Requisition requisition = new Requisition(/* provide necessary properties */);
            requisition.setMasterPosition(savedMasterPosition);
            requisition.setMasterExperience(existingMasterExperience);
            requisition.setOpeningDate(parsedDate);
            requisition.setTotalRequisition(requisitionRequest.getTotalRequisition());
            Requisition savedRequisition = requisitionService.createRequisition(requisition);

            return new ResponseEntity<>(savedRequisition, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("updateRequisition/{id}")
    public Requisition updateRequisition(@PathVariable int id, @RequestBody Requisition updatedRequisition) {
        return requisitionService.updateRequisition(id, updatedRequisition);
    }

    @DeleteMapping("deleteRequisition/{id}")
    public void deleteRequisition(@PathVariable int id) {
        requisitionService.deleteRequisition(id);
    }
}

