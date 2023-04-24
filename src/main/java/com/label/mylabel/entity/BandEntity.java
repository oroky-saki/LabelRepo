package com.label.mylabel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String label;
    private String genre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private List<MusicianEntity> musicians;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private List<AlbumEntity> albums;

    public BandEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MusicianEntity> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<MusicianEntity> musicians) {
        this.musicians = musicians;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }
}
