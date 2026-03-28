package com.martinc93.todolistapi.application.usecase.user;

import com.martinc93.todolistapi.application.ports.in.user.UpdateUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User execute(User user) {
        return userRepositoryPort.update(user);
    }
}
