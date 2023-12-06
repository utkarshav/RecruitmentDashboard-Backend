package com.example.demo.controller;

import com.example.demo.entity.RequisitionStatistics;
import com.example.demo.service.RequisitionService;
import com.example.demo.service.RequisitionStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/requisitionStatistics")
public class RequisitionStatisticsController
{
    @Autowired
    RequisitionStatisticsService requisitionStatisticsService;

    @Autowired
    RequisitionService requisitionService;

    @GetMapping("/getAllRequisitionStatistics")
    public List<RequisitionStatistics> getAllRequisitionStatistics() {
       return requisitionStatisticsService.getAllRequisitionStatistics();
    }

    @GetMapping("getRequisitionStatisticById/{id}")
    public RequisitionStatistics getRequisitionStatisticsById(@PathVariable int id) {
        return requisitionStatisticsService.getRequisitionStatisticsById(id);
    }

    @GetMapping

    @PostMapping
    public RequisitionStatistics saveRequisitionStatistics(@RequestBody RequisitionStatistics requisitionStatistics) {
        return requisitionStatisticsService.saveRequisitionStatistics(requisitionStatistics);
        }

//    @DeleteMapping("/{id}")
//    public RequisitionStatistics deleteRequisitionStatistics(@PathVariable int id) {
//       return requisitionStatisticsService.deleteRequisitionStatistics(id);
//    }



}
