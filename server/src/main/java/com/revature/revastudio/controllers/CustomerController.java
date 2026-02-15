package com.revature.revastudio.controllers;


import com.revature.revastudio.dto.PurchasedTrackDTO;
import com.revature.revastudio.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("tracks")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity <List<PurchasedTrackDTO>> getCustomerTracks(){
        UUID userId = (UUID) SecurityContextHolder.getContext().getAuthentication().getDetails();

        List<PurchasedTrackDTO> customerTrack = customerService.getAllTracks(userId);
        return ResponseEntity.ok(customerTrack);
        
    }


}
