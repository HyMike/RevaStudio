package com.revature.revastudio.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketThreadDTO {
    public Integer ticketThreadId;
    public Integer ticketId;
    public String thread;
    public LocalDateTime createdAt;

}
