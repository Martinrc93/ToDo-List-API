package com.martinc93.todolistapi.application.service.user;

import com.martinc93.todolistapi.application.ports.in.user.UpdateUserUseCase;
import com.martinc93.todolistapi.application.ports.in.user.command.UpdateUserCommand;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.exception.user.UserNotFoundException;
import com.martinc93.todolistapi.domain.model.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public User execute(UpdateUserCommand command) {

        User user = userRepositoryPort.findById(command.id())
                        .orElseThrow(()-> new UserNotFoundException("User not found with id: " + command.id()));
        user.update(command.userName());

        return userRepositoryPort.update(user);
    }
}
