package com.example.demo.service;

import com.example.demo.entity.RequisitionStatistics;
import com.example.demo.repository.RequisitionStatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitionStatisticsService {

    private RequisitionStatisticsRepository requisitionStatisticsRepository;

    @Autowired
    public RequisitionStatisticsService(RequisitionStatisticsRepository requisitionStatisticsRepository) {
        this.requisitionStatisticsRepository = requisitionStatisticsRepository;
    }

    public List<RequisitionStatistics> getAllRequisitionStatistics() {
        return requisitionStatisticsRepository.findAll();
    }

    public RequisitionStatistics getRequisitionStatisticsById(int id) {
        return requisitionStatisticsRepository.findById(id).get();
    }

    public RequisitionStatistics saveRequisitionStatistics(RequisitionStatistics requisitionStatistics) {
        return requisitionStatisticsRepository.save(requisitionStatistics);
    }

//    @Transactional
//    public RequisitionStatistics deleteRequisitionStatistics(int id)
//    {
//       return requisitionStatisticsRepository.deleteById(id);
//    }

    // Additional methods as needed

    // ...
}
