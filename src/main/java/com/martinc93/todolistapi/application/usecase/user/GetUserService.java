package com.martinc93.todolistapi.application.usecase.user;

import com.martinc93.todolistapi.application.ports.in.user.GetUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
/*
    @Override
    public User get(UUID id) {
        return userRepositoryPort.findById(id);
    }

 */
}
