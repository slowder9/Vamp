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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class EventController {

    private final String USER_KEY = "user";

    @Autowired
    EventRepository eventRepo;

    @Autowired
    LikesRepository likesRepo;

    @Autowired
    UserRepository userRepo;


    public EventController() {
    }

    @PostConstruct
    public void init() {
//        Event fakeEvent = new Event("Disc Golf", "Sports/Outdoors", Time.valueOf("10:00:00"), Time.valueOf("11:00:00"), "35.2270", "-80.8478");
//        fakeEvent.addLike(new Likes());
//        fakeEvent.addLike(new Likes());
//        eventRepo.save(fakeEvent);
    }

    @CrossOrigin
    @GetMapping(path = "/user")
    public User getUser(HttpSession session) {
        return (User) session.getAttribute(USER_KEY);
    }

    // persist (aka save) the user they sent us
    @CrossOrigin
    @PostMapping(path = "/user")
    public void signUp(@RequestBody User user, HttpServletResponse response) throws IOException {
        // if we can't find a user with the name specified...
        if (userRepo.findFirstByUserName(user.getUserName()) == null) {
            userRepo.save(user);
        } else {
            // we found a user with that name, respond with
            // an error code
            response.sendError(422, "User already exists");
        }
    }

    @CrossOrigin
    @PostMapping(path = "/login")
    public void login(@RequestBody User user, HttpSession session, HttpServletResponse response) throws IOException {
        // ASKS THE REPOSITORY:
        // Do you have any users with this username and password?
        User repoUser = userRepo.findFirstByUserNameAndPassword(user.getUserName(), user.getPassword());

        if (repoUser != null) {
            session.setAttribute(USER_KEY, repoUser);
        } else {
            response.sendError(401, "Bad credentials");
        }
    }

    @CrossOrigin
    @GetMapping(path = "/events")
    public List<Event> getEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/likes")
    public List<Likes> getLikes() {
        return (List<Likes>) likesRepo.findAll();
    }

    @CrossOrigin
    @PostMapping(path = "/add-events")
    // This is the event that the user submitted.
    // SPRING LOOKS AT THE FORM DATA AND BUILDS US
    // THIS EVENT.
    public void addEvent(@RequestBody Event submittedEvent) {
        eventRepo.save(submittedEvent);
        // save "submittedEvent" into the database.
    }

    @CrossOrigin
    @PostMapping(path = "/add-likes/{id}")
    public void addLike(@RequestBody Likes submittedLike, @PathVariable("id") int id) {
        Event e = eventRepo.findOne(id);
        e.addLike(submittedLike);
        eventRepo.save(e);
    }
}
