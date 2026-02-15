package com.revature.revastudio.services;

import com.revature.revastudio.controllers.CustomerController;
import com.revature.revastudio.dto.PurchasedTrackDTO;
import com.revature.revastudio.entity.Customer;
import com.revature.revastudio.entity.InvoiceLine;
import com.revature.revastudio.entity.User;
import com.revature.revastudio.repositories.CustomerRepository;
import com.revature.revastudio.repositories.InvoiceLineRepository;
import com.revature.revastudio.repositories.UserRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final InvoiceLineRepository invoiceLineRepository;
    private final UserRepository userRepository;


    public CustomerService(CustomerRepository customerRepository,
                           InvoiceLineRepository invoiceLineRepository,
                        UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.invoiceLineRepository = invoiceLineRepository;
        this.userRepository = userRepository;
    };


    public List<PurchasedTrackDTO> getAllTracks(UUID userId){
        User user = userRepository.findById(userId).orElseThrow();
        UUID customerId = user.getCustomer().getId();
        List<InvoiceLine> invoiceLines = invoiceLineRepository.findByCustomerId(customerId);

        List<PurchasedTrackDTO> purchasedTracks = invoiceLines.stream()
                .map(invoiceLine -> new PurchasedTrackDTO(
                    invoiceLine.getTrack().getName(),
                    invoiceLine.getTrack().getAlbum().getTitle(),
                    invoiceLine.getTrack().getAlbum().getArtist().getName()
                )
                ).toList();

        return purchasedTracks;

    }



}
