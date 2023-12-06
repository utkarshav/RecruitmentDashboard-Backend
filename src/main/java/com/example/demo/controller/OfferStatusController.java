package com.example.demo.controller;
import java.util.List;
import com.example.demo.entity.OfferStatus;
import com.example.demo.repository.OfferStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offersStatus")
@CrossOrigin(origins = "http://localhost:3000")

public class OfferStatusController
{
    @Autowired
    OfferStatusRepository offerStatusRepository;

    @GetMapping("allOfferStatus")
    public List<OfferStatus> getAll()
    {
        return offerStatusRepository.findAll();
    }
}
