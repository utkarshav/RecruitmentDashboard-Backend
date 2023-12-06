package com.example.demo.controller;

import com.example.demo.entity.OfferStatus;
import com.example.demo.entity.Offers;
import com.example.demo.entity.Requisition;
import com.example.demo.entity.RequisitionStatistics;
import com.example.demo.repository.OfferStatusRepository;
import com.example.demo.service.OffersService;
import com.example.demo.service.RequisitionStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offers")
@CrossOrigin(origins = "http://localhost:3000")

public class OffersController {

    @Autowired
    private OffersService offersService;

    @Autowired
    private  OfferStatusRepository offerStatusRepository;

    @Autowired
    private RequisitionStatisticsService requisitionStatisticsService;

    @GetMapping("/getAllOffers")
    public List<Offers> getAllOffersWithDetails() {
        List<Offers> offersList = offersService.getAllsOffers();

        // Iterate through the offers and fetch related data for each offer
        for (Offers offer : offersList) {
            // Fetch and set requisition statistics
            RequisitionStatistics requisitionStatistics = offer.getRequisitionStatistics();
            // 'requisitionStatistics' is already loaded due to the @ManyToOne mapping

            // Fetch and set status if 'statusId' is not null
            if (offer.getStatusId() != null) {
                OfferStatus status = offer.getStatusId();
                // Set the status in the offer
                offer.setStatusId(status);
            }
        }

        return offersList;
    }

    @GetMapping("/getOffersByRequisitionId/{requisitionId}")
    public List<Offers> getOffersByRequisitionId(@PathVariable int requisitionId )
    {
//        Requisition requisition = new Requisition();
//        requisition.setId(requisitionId);
        return offersService.findOffersByRequisitionId(requisitionId);
    }




    @GetMapping("/getOfferById/{id}")
    public Optional<Offers> getOfferById(@PathVariable int id) {
        return offersService.getOfferById(id);
    }

    @PostMapping("/createOffer")
    public Offers createOffer(@RequestBody Offers offer) {
        return offersService.createOffer(offer);
    }

    @PutMapping("/updateOffer/{id}")
    public Offers updateOffer(@PathVariable int id, @RequestBody Offers offer) {
        return offersService.updateOffer(id, offer);
    }

    @DeleteMapping("/deleteOffer/{id}")
    public void deleteOffer(@PathVariable int id) {
        offersService.deleteOffer(id);
    }
}

