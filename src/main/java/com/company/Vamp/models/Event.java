package com.company.Vamp.models;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;


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

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Likes> likes = new ArrayList<Likes>();

    public Event() {

    }

    public Event(String description, String category, Time eventStart, Time eventEnd, String latitude, String longitude) {
        this.description = description;
        this.category = category;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public void addLike(Likes likes) {
        this.likes.add(likes);
    }
}

