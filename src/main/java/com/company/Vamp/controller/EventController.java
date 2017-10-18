package com.company.Vamp.controller;

import com.company.Vamp.models.Event;
import com.company.Vamp.viewModels.EventView;
import com.company.Vamp.repositories.EventRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepo;

    List<Event> events = new ArrayList<>();

    public EventController() {
        events.add(new Event(0, "Disc Golf", "Sports/Outdoors", LocalDate.now().atTime(6,0), LocalDate.now().atTime(9, 30), "35.2270", "-80.8478"));
//        events.add(new Event(1, "Happy Hour", "Food/Bev", LocalDateTime.now(), LocalDateTime.now(), "35.2087° N", "80.8628° W"));
//        events.add(new Event(2, "Puppy Adoption", "Community", LocalDateTime.now(), LocalDateTime.now(), "35.1522° N", "80.8318° W"));
    }

    @PostConstruct
    public void init() {
    }

    @CrossOrigin
    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return events;
    }
//    public EventView homepage() {
//        EventView model = new EventView();
//        Vamp fakeEvent = new Vamp(0, "Disc Golf", "Sports/Outdoors", LocalDateTime.now(), LocalDateTime.now(),"Romare Bearden Park");
//
//        model.getEvents().add(fakeEvent);
//
//        return model;
//    }

    @CrossOrigin
    @RequestMapping(path = "/add-events", method = RequestMethod.POST)
    // This is the event that the user submitted.
    // SPRING LOOKS AT THE FORM DATA AND BUILDS US
    // THIS EVENT. THIS IS AWESOME.
    public String addEvent(Event submittedEvent) {
        eventRepo.save(submittedEvent);
    // save "submittedEvent" into the database.
        return "redirect:/";
    }
}