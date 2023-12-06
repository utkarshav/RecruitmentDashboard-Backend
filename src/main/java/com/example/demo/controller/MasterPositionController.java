package com.example.demo.controller;



import com.example.demo.entity.*;
import com.example.demo.repository.DeptRepository;
import com.example.demo.service.MasterPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DeptService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/masterPositions")
public class MasterPositionController {

    @Autowired
    MasterPositionService masterPositionService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/getAllMasterPositions")
    public List<MasterPosition> getAllMasterPositions() {
        return masterPositionService.getAllMasterPositions();
    }



    @PostMapping("/saveMasterPosition")
    public MasterPosition saveMasterPosition(@RequestBody MasterPosition masterPosition)
    {
        Dept dept = deptService.findDeptById(masterPosition.getDept().getId());
        MasterPosition masterPosition1 = new MasterPosition(dept,masterPosition.getName());
        masterPositionService.createMasterPosition(masterPosition1);
        return masterPosition1;
    }





    @GetMapping("getMasterPositionById/{id}")
    public MasterPosition getMasterPositionById(@PathVariable int id) {
        return masterPositionService.getMasterPositionById(id);
    }

    @PutMapping("updateMasterPositionById/{id}")
    public MasterPosition updateMasterPosition(@PathVariable int id, @RequestBody MasterPosition masterPosition) {
        return masterPositionService.updateMasterPosition(id, masterPosition);
    }

    @DeleteMapping("deleteMasterPositionById/{id}")
    public void deleteMasterPosition(@PathVariable int id) {
        masterPositionService.deleteMasterPosition(id);
    }
}

