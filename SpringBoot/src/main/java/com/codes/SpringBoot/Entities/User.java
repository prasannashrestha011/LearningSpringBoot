package com.codes.SpringBoot.Entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private int id;

    public String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
