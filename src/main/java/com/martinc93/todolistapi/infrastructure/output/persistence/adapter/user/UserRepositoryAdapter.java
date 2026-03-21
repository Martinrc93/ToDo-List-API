package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.user;

import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }
/*
    @Override
    public User findById(UUID id) {
        return userRepository.findById(id);
    }
    */

}
