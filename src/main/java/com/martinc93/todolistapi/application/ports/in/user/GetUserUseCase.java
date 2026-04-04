package com.martinc93.todolistapi.application.ports.in.user;

import com.martinc93.todolistapi.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface GetUserUseCase {

        Optional<User> get (Long id);

        Page<User> list (Pageable pageable);

        Optional<User> getByUserName (String userName);

        Optional<User> getByEmail (String email);

}
