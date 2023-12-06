package com.example.demo.service;



import com.example.demo.entity.Offers;
import com.example.demo.entity.Requisition;
import com.example.demo.repository.OffersRepository;
import com.example.demo.repository.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OffersService {

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private RequisitionRepository requisitionRepository;

    public List<Offers> getAllsOffers() {
        return offersRepository.findAll();
    }
    public List<Offers> findOffersByRequisitionId(int requisitionId) {
        Requisition requisition = requisitionRepository.findById(requisitionId).orElse(null);

        if (requisition != null) {
            return offersRepository.findOffersByRequisitionId(requisitionId);
        } else {
            // Handle the case where requisition with the given ID is not found
            return Collections.emptyList();
        }
    }

    public Optional<Offers> getOfferById(int id) {
        return offersRepository.findById(id);
    }

    public Offers createOffer(Offers offers) {
        return offersRepository.save(offers);
    }

    public Offers updateOffer(int id, Offers offer) {
        Optional<Offers> existingOffer = offersRepository.findById(id);

        if (existingOffer.isPresent()) {
            Offers updatedOffer = existingOffer.get();
            // Update the fields of the existing offer with the new values

            updatedOffer.setOfferDate(offer.getOfferDate());
            updatedOffer.setDaysTakenToOffer(offer.getDaysTakenToOffer());
            updatedOffer.setDaysTakenToJoin(offer.getDaysTakenToJoin());
            updatedOffer.setDelay(offer.getDelay());
            updatedOffer.setStatusId(offer.getStatusId());
            updatedOffer.setJoiningDate(offer.getJoiningDate());
            updatedOffer.setCreatedBy(offer.getCreatedBy());
            updatedOffer.setCreatedDate(offer.getCreatedDate());
            updatedOffer.setModifiedBy(offer.getModifiedBy());
            updatedOffer.setModifiedDate(offer.getModifiedDate());

            return offersRepository.save(updatedOffer);
        } else {
            return null; // Handle not found case
        }
    }


    public void deleteOffer(int id) {
        offersRepository.deleteById(id);
    }
}

