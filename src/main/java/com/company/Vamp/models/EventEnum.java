package com.company.Vamp.models;

public enum EventEnum {
    SPORTS_OUTDOORS("Sports and Outdoors"),
    MUSIC_ART("Music and Art"),
    COMMUNITY("Community"),
    FOOD_BEV("Food and Beverage");

    private String eventType;

    public String getEventType() {
        return eventType;
    }

    EventEnum(String eventType) {
        this.eventType = eventType;
    }
}
