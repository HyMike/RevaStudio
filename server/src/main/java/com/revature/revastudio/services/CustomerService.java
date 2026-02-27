package com.revature.revastudio.services;

import com.revature.revastudio.controllers.CustomerController;
import com.revature.revastudio.dto.PurchasedTrackDTO;
import com.revature.revastudio.dto.TicketRequestDTO;
import com.revature.revastudio.dto.TicketResponseDTO;
import com.revature.revastudio.entity.Customer;
import com.revature.revastudio.entity.InvoiceLine;
import com.revature.revastudio.entity.Ticket;
import com.revature.revastudio.entity.User;
import com.revature.revastudio.enums.TicketStatus;
import com.revature.revastudio.repositories.CustomerRepository;
import com.revature.revastudio.repositories.InvoiceLineRepository;
import com.revature.revastudio.repositories.TicketRepository;
import com.revature.revastudio.repositories.UserRepository;

import com.revature.revastudio.util.RetrieveCustomer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final InvoiceLineRepository invoiceLineRepository;
    private final UserRepository userRepository;
    private final RetrieveCustomer retrieveCustomer;
    private final TicketRepository ticketRepository;


    public CustomerService(CustomerRepository customerRepository,
        InvoiceLineRepository invoiceLineRepository,
        UserRepository userRepository,
        RetrieveCustomer retrieveCustomer,
       TicketRepository ticketRepository
    ) {
        this.customerRepository = customerRepository;
        this.invoiceLineRepository = invoiceLineRepository;
        this.userRepository = userRepository;
        this.retrieveCustomer = retrieveCustomer;
        this.ticketRepository = ticketRepository;
    };


    public List<PurchasedTrackDTO> getAllTracks(UUID userId){
        User user = userRepository.findById(userId).orElseThrow();
        Integer customerId = user.getCustomer().getCustomerId();
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

    //button clicks to create ticket. the ticket then has a controller that create the subject, body, and set the status.

    public TicketResponseDTO createTicket(TicketRequestDTO ticket){
        String subject = ticket.getSubject();
        String body = ticket.getBody();
        LocalDateTime currentTime = LocalDateTime.now();
        Customer customer = retrieveCustomer.getCustomer();
        Ticket newTicket = new Ticket(
                null,
                subject,
                body,
                currentTime,
                TicketStatus.OPEN,
                customer,
                null,
                null
        );
        Ticket savedTicket = ticketRepository.save(newTicket);
        return new TicketResponseDTO(
            savedTicket.getTicketId(),
            savedTicket.getSubject(),
            savedTicket.getBody(),
            savedTicket.getCreatedAt(),
            savedTicket.getStatus(),
            savedTicket.getCustomer().getCustomerId(),
            savedTicket.getEmployee() != null ? savedTicket.getEmployee().getEmployeeId() : null
        );
        


    }



}
