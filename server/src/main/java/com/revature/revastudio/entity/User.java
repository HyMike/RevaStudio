package com.revature.revastudio.entity;

import com.revature.revastudio.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    @Size(min=1, max=20)
    private String username;

    @Column(nullable = false)
    @Size(min=1, max=20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


}


