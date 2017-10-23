package com.company.Vamp.repositories;

import com.company.Vamp.models.Likes;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface LikesRepository
        extends CrudRepository<Likes, Integer> {
}
