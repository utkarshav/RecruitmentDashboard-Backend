package com.example.demo.service;

import com.example.demo.entity.RequisitionStatus;
import com.example.demo.repository.RequisitionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionStatusService
{
    @Autowired
    RequisitionStatusRepository requisitionStatusRepository;

    public List<RequisitionStatus> getAllStatus()
    {
        return  requisitionStatusRepository.findAll();
    }
}
