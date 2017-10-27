package com.company.Vamp.repositories;

import com.company.Vamp.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository
        extends CrudRepository<Event, Integer> {
}
