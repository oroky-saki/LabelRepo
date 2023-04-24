package com.label.mylabel.model;

import com.label.mylabel.entity.AlbumEntity;

public class Album {
    private String title;
    private Integer year;

    public Album() {
    }

    public static Album toModel(AlbumEntity entity) {
        Album model = new Album();
        model.setTitle(entity.getTitle());
        model.setYear(entity.getYear());
        return model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
