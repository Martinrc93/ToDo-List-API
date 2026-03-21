package com.martinc93.todolistapi.application.usecase.user;


import com.martinc93.todolistapi.application.ports.in.user.CreateUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public User execute(User user) {
        return userRepositoryPort.save(user);
    }


}
