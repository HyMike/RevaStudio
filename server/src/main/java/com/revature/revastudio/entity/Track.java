package com.revature.revastudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    @Size(min = 1)
    private String name;

    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    @OneToMany(mappedBy = "track")
    private Set<InvoiceLine> invoiceLines;

}
