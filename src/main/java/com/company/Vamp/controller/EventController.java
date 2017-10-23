package com.company.Vamp.controller;

import com.company.Vamp.models.Event;
import com.company.Vamp.models.Likes;
import com.company.Vamp.models.User;
import com.company.Vamp.repositories.EventRepository;
import com.company.Vamp.repositories.LikesRepository;
import com.company.Vamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import org.springframework.ui.Model;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepo;

    @Autowired
    LikesRepository likesRepo;

    @Autowired
    UserRepository userRepo;

//    List<Event> events = new ArrayList<>();
//
//    List<Likes> likes = new ArrayList<>();

    public EventController() {
//        Event fakeEvent = new Event(0, "Disc Golf", "Sports/Outdoors", Time.valueOf("10:00:00"), Time.valueOf("11:00:00"), "35.2270", "-80.8478");
//        fakeEvent.addLike(new Likes(0));
//        fakeEvent.addLike(new Likes(1));
//        eventRepo.save(fakeEvent);
//        eventRepo.save(new Event(0, "Disc Golf", "Sports/Outdoors", Time.valueOf("10:00:00"), Time.valueOf("11:00:00"), "35.2270", "-80.8478"));
//        events.add(new Event(1, "Happy Hour", "Food/Bev", LocalDateTime.now(), LocalDateTime.now(), "35.2087° N", "80.8628° W"));
//        events.add(new Event(2, "Puppy Adoption", "Community", LocalDateTime.now(), LocalDateTime.now(), "35.1522° N", "80.8318° W"));
//        likesRepo.save(new Likes(0));
//        likesRepo.save(new Likes(1));
    }

    @PostConstruct
    public void init() {
        Event fakeEvent = new Event("Disc Golf", "Sports/Outdoors", Time.valueOf("10:00:00"), Time.valueOf("11:00:00"), "35.2270", "-80.8478");
        fakeEvent.addLike(new Likes());
        fakeEvent.addLike(new Likes());
        eventRepo.save(fakeEvent);
    }

    @PostConstruct
    public void fakeUser() {
        if (userRepo.count() == 0) {

            User u = new User();
            u.setUserName("fakeUser1@vamp.com");
            u.setPassword("123");
            userRepo.save(u);
        }

        if (userRepo.count() == 1) {
            User u = new User();
            u.setUserName("fakeUser2@vamp.com");
            u.setPassword("abc");
            userRepo.save(u);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("current_user") == null) {
            return "signup";
        }
        return "index";
    }

    @CrossOrigin
    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String signUp(@RequestBody User createdUser, HttpSession session) {
        userRepo.save(createdUser);
        session.setAttribute("current_user", createdUser);
        return "/";
    }

    @CrossOrigin
    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    @CrossOrigin
    @RequestMapping(path = "/likes", method = RequestMethod.GET)
    public List<Likes> getLikes() {
        return (List<Likes>) likesRepo.findAll();
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

        // save "submittedEvent" into the database.
        return "redirect:/";
    }

    @CrossOrigin
    @RequestMapping(path = "/add-likes", method = RequestMethod.POST)
    public int addLike(@RequestBody Likes submittedLike) {
        likesRepo.save(submittedLike);

        return 0;
    }
}
