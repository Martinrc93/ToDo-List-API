package com.martinc93.todolistapi.application.ports.in.user;

import com.martinc93.todolistapi.application.ports.in.user.command.CreateUserCommand;
import com.martinc93.todolistapi.domain.model.user.User;

public interface CreateUserUseCase {
    User execute (CreateUserCommand command);
}
