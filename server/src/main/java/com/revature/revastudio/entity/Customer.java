package com.revature.revastudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, updatable = false)
    private Integer customerId;

    @Column(name = "first_name", nullable = false)
    @Size(min = 1, max = 40)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 1, max = 20)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "support_rep_id")
    private Employee supportRep;

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;

    @OneToOne(mappedBy = "customer")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> customerTickets;



}
