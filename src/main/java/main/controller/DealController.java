package main.controller;

import main.exception.ResourceNotFoundException;
import main.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.repository.DealRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DealController {

    @Autowired
    DealRepository dealRepository;

    //Get All Deal
    @GetMapping("/deals")
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    //Create New Deal
    @PostMapping("/deals")
    public Deal createDeal(@Valid @RequestBody Deal deal) {
        return dealRepository.save(deal);
    }

    //Get A single Deal
    @GetMapping("/deals/{id}")
    public Deal getDealById(@PathVariable(value = "id") Long dealId) {
        return dealRepository.findById(dealId)
                .orElseThrow(()-> new ResourceNotFoundException("Deal", "id", dealId));

    }

    //Update Deal
    @PutMapping("/deals/{id}")
    public Deal updateDeal(@PathVariable(value = "id") Long dealId,
                               @Valid @RequestBody Deal dealDetails) {

        Deal deal = dealRepository.findById(dealId).orElseThrow(()
                -> new ResourceNotFoundException("Course", "id", dealId));

        deal.setDealCategory(dealDetails.getDealCategory());
        deal.setDealPartner(dealDetails.getDealPartner());
        deal.setDealPrice(dealDetails.getDealPrice());

        Deal updatedDeal = dealRepository.save(deal);

        return updatedDeal;
    }

    //Delete Deal
    @DeleteMapping("/deals/{id}")
    public ResponseEntity<?> deleteDeal(@PathVariable(value = "id") Long dealId) {
        Deal deal = dealRepository.findById(dealId)
                .orElseThrow(()-> new ResourceNotFoundException("Deal", "id", dealId));
        dealRepository.delete(deal);

        return ResponseEntity.ok().build();
    }
}
