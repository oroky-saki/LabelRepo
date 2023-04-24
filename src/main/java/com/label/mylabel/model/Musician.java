package com.label.mylabel.model;

import com.label.mylabel.entity.MusicianEntity;

public class Musician {
    private String name;
    private String surname;
    private String role;

    public static Musician toModel(MusicianEntity entity) {
        Musician model = new Musician();
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setRole(entity.getRole());
        return model;
    }

    public Musician() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
