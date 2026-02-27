package com.revature.revastudio.controllers;


import com.revature.revastudio.dto.PurchasedTrackDTO;
import com.revature.revastudio.dto.TicketRequestDTO;
import com.revature.revastudio.dto.TicketResponseDTO;
import com.revature.revastudio.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create-ticket")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<TicketResponseDTO> createTicket(@RequestBody TicketRequestDTO ticket){
            TicketResponseDTO ticketResponse = customerService.createTicket(ticket);
            return ResponseEntity.status(201).body(ticketResponse);
    }


}
