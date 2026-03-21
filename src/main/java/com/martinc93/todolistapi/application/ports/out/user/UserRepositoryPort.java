package com.martinc93.todolistapi.application.ports.out.user;

import com.martinc93.todolistapi.domain.model.user.User;

import java.util.UUID;

public interface UserRepositoryPort {

    User save(User user);
    //User findById(UUID id);

}
