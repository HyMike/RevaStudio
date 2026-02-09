package com.revature.revastudio.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime invoiceDate;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceLine> invoiceLines;


}
