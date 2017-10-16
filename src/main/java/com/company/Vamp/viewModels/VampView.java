package com.company.Vamp.viewModels;

import com.company.Vamp.models.Vamp;
import java.util.List;
import java.util.ArrayList;

public class VampView {
    List<Vamp> events = new ArrayList<>();

    public VampView() {
    }

    public List<Vamp> getEvents() {
        return events;
    }

    public void setEvents(List<Vamp> events) {
        this.events = events;
    }

    public VampView(List<Vamp> events) {
        this.events = events;
    }
}
