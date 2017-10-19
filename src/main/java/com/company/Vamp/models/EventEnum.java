package com.company.Vamp.models;

public enum EventEnum {
    SPORTS_OUTDOORS("Sports and Outdoors"),
    MUSIC_ART("Music and Art"),
    COMMUNITY("Community"),
    FOOD_BEV("Food and Beverage");

    private String category;

    public String getCategory() {
        return category;
    }

    EventEnum(String category) {
        this.category = category;
    }
}
