package com.example.demo.controller;

import com.example.demo.entity.MasterExperience;
import com.example.demo.service.MasterExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Experiences")
public class MasterExperienceController {

    @Autowired
    private MasterExperienceService masterExperienceService;

    @GetMapping("/getAllExperience")
    public List<MasterExperience> getAllMasterExperiences() {
        return masterExperienceService.getAllMasterExperiences();
    }

    @GetMapping("getExperienceById/{id}")
    public MasterExperience getMasterExperienceById(@PathVariable int id) {
        return masterExperienceService.getMasterExperienceById(id);
    }

    @PostMapping("/saveExperience")
    public MasterExperience saveMasterExperience(@RequestBody MasterExperience masterExperience) {
        return masterExperienceService.createMasterExperience(masterExperience);
    }

    @PutMapping("updateExperienceById/{id}")
    public MasterExperience updateMasterExperience(@PathVariable int id, @RequestBody MasterExperience masterExperience) {
        return masterExperienceService.updateMasterExperience(id, masterExperience);
    }

    @DeleteMapping("deleteExperienceById/{id}")
    public void deleteMasterExperience(@PathVariable int id) {
        masterExperienceService.deleteMasterExperience(id);
    }
}

