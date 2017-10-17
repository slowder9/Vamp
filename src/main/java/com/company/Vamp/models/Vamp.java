package com.company.Vamp.models;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Vamp {
    @Id//this is a primary key column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//the value of "id" will be automatically generated
            int id;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private LocalDateTime eventStart;

    @Column
    private LocalDateTime eventEnd;

    @Column
    private String Location;

    @Column
    private EventEnum eventCategory ;

    public Vamp(int id, String description, String category, LocalDateTime eventStart, LocalDateTime eventEnd, String location) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        Location = location;
    }

    public Vamp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getEventStart() {
        return eventStart;
    }

    public void setEventStart(LocalDateTime eventStart) {
        this.eventStart = eventStart;
    }

    public LocalDateTime getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(LocalDateTime eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
