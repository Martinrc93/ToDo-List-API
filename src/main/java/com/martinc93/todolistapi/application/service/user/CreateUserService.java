package com.martinc93.todolistapi.application.service.user;

import com.martinc93.todolistapi.application.ports.in.user.CreateUserUseCase;
import com.martinc93.todolistapi.application.ports.in.user.command.CreateUserCommand;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public User execute(CreateUserCommand command) {

        User user = User.createNewUser(command.userName(), command.email(), command.password());
        return userRepositoryPort.save(user);
    }

}
