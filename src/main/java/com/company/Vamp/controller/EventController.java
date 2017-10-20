package com.company.Vamp.controller;

import com.company.Vamp.models.Event;
import com.company.Vamp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepo;

    List<Event> events = new ArrayList<>();

    public EventController() {
        events.add(new Event(0, "Disc Golf", "Sports/Outdoors", Time.valueOf("10:00:00"), Time.valueOf("11:00:00"), "35.2270", "-80.8478"));
//        events.add(new Event(1, "Happy Hour", "Food/Bev", LocalDateTime.now(), LocalDateTime.now(), "35.2087° N", "80.8628° W"));
//        events.add(new Event(2, "Puppy Adoption", "Community", LocalDateTime.now(), LocalDateTime.now(), "35.1522° N", "80.8318° W"));
    }

    @PostConstruct
    public void init() {
    }

    @CrossOrigin
    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents()
    {
        return (List<Event>)eventRepo.findAll();
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
    public String addEvent(@RequestBody Event submittedEvent) {
        eventRepo.save(submittedEvent);
<<<<<<< HEAD
    // save "submittedEvent" into the database.

=======
        // save "submittedEvent" into the database.
>>>>>>> fa9acfef16907be04fb664cc8928dd6a5a27f86c
        return "redirect:/";
    }
    @CrossOrigin
    @PostMapping("/events")
    public int like(@RequestBody Event click) {
        eventRepo.save(click);
        return 0;
    }
}
