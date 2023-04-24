package com.label.mylabel.entity;

import jakarta.persistence.*;

@Entity
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private BandEntity band;
}
