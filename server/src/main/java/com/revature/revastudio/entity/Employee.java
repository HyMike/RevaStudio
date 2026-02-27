package com.revature.revastudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false, updatable = false)
    private Integer employeeId;

    @Column(name = "last_name", nullable = false)
    @Size(min = 1, max = 20)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    @Size(min = 1, max = 20)
    private String firstName;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "supportRep")
    private List<Customer> customers;

    @OneToOne(mappedBy = "employee")
    private User user;

    @OneToMany(mappedBy="employee")
    private List<Ticket> tickets;


}
