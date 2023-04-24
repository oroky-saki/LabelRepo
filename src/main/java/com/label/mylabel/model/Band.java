package com.label.mylabel.model;

import com.label.mylabel.entity.BandEntity;

public class Band {
    private String name;
    private String label;
    private String genre;

    public Band() {
    }

    public static Band toModel(BandEntity entity) {
        Band model = new Band();
        model.setName(entity.getName());
        model.setLabel(entity.getLabel());
        model.setGenre(entity.getGenre());
        return model;
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

}
