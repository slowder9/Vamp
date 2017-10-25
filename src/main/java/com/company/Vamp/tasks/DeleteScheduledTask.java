package com.company.Vamp.tasks;

import com.company.Vamp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.Instant;
import java.util.Date;

@Component
public class DeleteScheduledTask {
    @Autowired
    EventRepository eventsRepo;

    @Scheduled(cron = "0 59 23 * * ? *")
    public void wipeEvents() {
        eventsRepo.deleteAll();
    }
}
