package com.company.Vamp.repositories;

import com.company.Vamp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Integer> {

    User findFirstByUserName(String username);

    User findFirstByUserNameAndPassword(String username, String password);
}
