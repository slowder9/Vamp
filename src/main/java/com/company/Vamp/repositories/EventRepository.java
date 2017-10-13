package com.company.Vamp.repositories;

import com.company.Vamp.models.Vamp;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface EventRepository
        extends CrudRepository<Vamp, Integer> {
}
