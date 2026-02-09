package com.revature.revastudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", nullable=false, updatable=false)
    private UUID id;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String lastName;

    @ManyToOne
    @JoinColumn(name="client")
    private Employee supportRep;

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices;

    @OneToOne(mappedBy = "customer")
    private User user;

    //Didn't implement the rest for mvp purpose such as address, email, phone number


}
