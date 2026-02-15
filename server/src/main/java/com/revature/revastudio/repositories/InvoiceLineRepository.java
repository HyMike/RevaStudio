package com.revature.revastudio.repositories;


import com.revature.revastudio.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, UUID> {
    @Query("SELECT il FROM InvoiceLine il JOIN FETCH il.track t JOIN FETCH t.album a JOIN FETCH a.artist WHERE il.invoice.customer.id = :customerId")
    List<InvoiceLine> findByCustomerId(@Param("customerId") UUID customerId);
}
