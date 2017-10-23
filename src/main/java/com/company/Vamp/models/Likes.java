package com.company.Vamp.models;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @Column(nullable = false)
//    private String user;

//    public Likes(int id) {
//        this.id = id;
//    }

    public Likes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                '}';
    }
}
