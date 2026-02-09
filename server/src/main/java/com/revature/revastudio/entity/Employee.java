package com.revature.revastudio.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable=false)
    private UUID id;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String lastName;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "supportRep")
    private List<Customer> client;

    @OneToOne(mappedBy = "employee")
    private User user;
}