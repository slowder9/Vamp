package com.company.Vamp.models;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public Likes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                '}';
    }
}
