package com.company.Vamp.models;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@Table(name = "events")
public class Event {
    @Id//this is a primary key column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//the value of "id" will be automatically generated
            int id;


    @Column(nullable = true)
    private int like;

    private static int LIKE_COUNTER;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Time eventStart;

    @Column(nullable = false)
    private Time eventEnd;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

//    @Column(nullable = true)
//    private int like;

//    LocalDateTime eventTime = LocalDateTime.now().atTime();

    public Event() {
    }

    public Event(int id, String description, String category, Time eventStart, Time eventEnd, String latitude, String longitude) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.latitude = latitude;
        this.longitude = longitude;
//        this.like = like;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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

    public Time getEventStart() {
        return eventStart;
    }

    public void setEventStart(Time eventStart) {
        this.eventStart = eventStart;
    }

    public Time getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Time eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

<<<<<<< HEAD
//    public int getLike() {
//        return like;
//    }
//
//    public void setLike(int like) {
//        this.like = like;
//    }
=======
    public static Event makeLike() {
        Event e = new Event();
        e.setLike(LIKE_COUNTER);
        LIKE_COUNTER++;
        return e;
    }
>>>>>>> fa9acfef16907be04fb664cc8928dd6a5a27f86c
}

