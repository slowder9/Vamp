package com.company.Vamp.repositories;

import com.company.Vamp.models.User;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface UserRepository
        extends CrudRepository<User, Integer> {

}
