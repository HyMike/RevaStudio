package com.revature.revastudio.dto;

import com.revature.revastudio.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDTO {
    private Integer ticketId;
    private String subject;
    private String body;
    private LocalDateTime createdAt;
    private TicketStatus status;
    private Integer customerId;
    private Integer employeeId;

}
