package com.example.demo.controller;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/depts")
public class DeptController
{
    @Autowired
    DeptService deptService;

    @GetMapping("/allDept")
    public List<Dept> getAllDepts() {
        return deptService.allDept();
    }

    @PostMapping("/saveDept")
    public Dept createDept(@RequestBody Dept dept) {
        return deptService.saveDept(dept);
    }

    @PutMapping("updateDept/{id}")
    public Dept updateDept(@PathVariable int id, @RequestBody Dept updatedDept) {
        return deptService.updateDept(id, updatedDept);
    }

    @DeleteMapping("deleteDept/{id}")
    public void deleteDept(@PathVariable int id) {deptService.deleteDept(id);
    }

}
