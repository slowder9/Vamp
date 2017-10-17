package com.company.Vamp.viewModels;

import com.company.Vamp.models.Event;
import java.util.List;
import java.util.ArrayList;

public class EventView {
    List<Event> events = new ArrayList<>();

    public EventView() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public EventView(List<Event> events) {
        this.events = events;
    }
}
