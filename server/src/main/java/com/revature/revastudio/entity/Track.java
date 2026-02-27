package com.revature.revastudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id", nullable = false, updatable = false)
    private Integer trackId;

    @Column(name = "name", nullable = false)
    @Size(min = 1)
    private String name;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "composer")
    private String composer;

    @Column(name = "milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "bytes")
    private Integer bytes;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "track")
    private Set<InvoiceLine> invoiceLines;

}
