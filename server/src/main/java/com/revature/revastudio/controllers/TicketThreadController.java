package com.revature.revastudio.controllers;

import com.revature.revastudio.dto.TicketThreadDTO;
import com.revature.revastudio.services.TicketThreadService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket-threads")
public class TicketThreadController {

    private final TicketThreadService ticketThreadService;

    public TicketThreadController(
            TicketThreadService ticketThreadService
    ) {
        this.ticketThreadService = ticketThreadService;
    }

    @GetMapping("{ticketId}")
    public ResponseEntity<List<TicketThreadDTO>> getThreadMessages(@RequestParam Integer ticketId) {

        List<TicketThreadDTO> threadMessages = this.ticketThreadService.getThreadMessages(ticketId);

        return ResponseEntity.ok(threadMessages);

    }





}
