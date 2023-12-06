package com.example.demo.service;

import com.example.demo.entity.Dept;
import com.example.demo.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptService
{
    @Autowired
    DeptRepository deptRepository;

    public List<Dept> allDept()
    {
        return deptRepository.findAll();
    }

    public Dept saveDept(Dept dept)
    {
        return deptRepository.save(dept);
    }

    public  Dept findDeptById(int deptId) {
        return deptRepository.findById(deptId).get();
    }

    public Dept updateDept(int deptId, Dept updatedDept) {
        Optional<Dept> existingDept = deptRepository.findById(deptId);
        if (existingDept.isPresent()) {
            Dept dept = existingDept.get();
            dept.setName(updatedDept.getName());
            return deptRepository.save(dept);
        } else {
            throw new IllegalArgumentException("Department not found with id: " + deptId);
        }
    }

    public void deleteDept(int deptId) {
        deptRepository.deleteById(deptId);
    }
}


