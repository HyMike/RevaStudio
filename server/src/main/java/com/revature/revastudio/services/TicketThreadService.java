package com.revature.revastudio.services;

import com.revature.revastudio.controllers.TicketThreadController;
import com.revature.revastudio.dto.TicketThreadDTO;
import com.revature.revastudio.entity.TicketThread;
import com.revature.revastudio.repositories.TicketThreadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketThreadService {

    private final TicketThreadRepository ticketThreadRepository;

    public TicketThreadService(
        TicketThreadRepository ticketThreadRepository
    ) {
        this.ticketThreadRepository = ticketThreadRepository;
    }

    // implement to get all tickets in the database and return it to the frontend.

    public List<TicketThreadDTO> getThreadMessages(Integer ticketId) {

        List<TicketThread> ticketThreads = this.ticketThreadRepository.findByTicket_TicketId(ticketId);
        return ticketThreads.stream()
                .map((ticketThread) ->  {
                    return new TicketThreadDTO(
                            ticketThread.getTicketThreadId(),
                            ticketId,
                            ticketThread.getThread(),
                            ticketThread.getCreatedAt()
                    );

                }).toList();

    }


}
