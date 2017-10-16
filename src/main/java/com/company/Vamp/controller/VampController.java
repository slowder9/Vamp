package com.company.Vamp.controller;

import com.company.Vamp.models.Vamp;
import com.company.Vamp.viewModels.VampView;
import com.company.Vamp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@RestController
public class VampController {

    @Autowired
    EventRepository eventRepo;

    List<Vamp> events = new ArrayList<>();

    public VampController() {
        events.add(new Vamp(0, "Disc Golf", "Sports/Outdoors", LocalDateTime.now(), LocalDateTime.now(), "300 S Church St, Charlotte, NC 28202"));
        events.add(new Vamp(1, "Happy Hour", "Food/Bev", LocalDateTime.now(), LocalDateTime.now(), "222 S Church St, Charlotte, NC 28202"));
        events.add(new Vamp(2, "Puppy Adoption", "Community", LocalDateTime.now(), LocalDateTime.now(), "2000 South Blvd #200, Charlotte, NC 28203"));
    }

    @PostConstruct
    public void init() {
    }
//    public void postConstruct() {
//        Vamp fakeEvent = new Vamp();
//    }

    @CrossOrigin
    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Vamp> getEvents() {
        return events;
    }
//    public VampView homepage() {
//        VampView model = new VampView();
//        Vamp fakeEvent = new Vamp(0, "Disc Golf", "Sports/Outdoors", LocalDateTime.now(), LocalDateTime.now(),"Romare Bearden Park");
//
//        model.getEvents().add(fakeEvent);
//
//        return model;
//    }

}
