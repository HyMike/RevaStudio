package com.revature.revastudio.repositories;

import com.revature.revastudio.entity.TicketThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface TicketThreadRepository extends JpaRepository<TicketThread, Integer> {
}

