package com.martinc93.todolistapi.application.ports.in.user;

import com.martinc93.todolistapi.domain.model.user.User;

public interface DeleteTaskUseCase {
    User execute (User user);
}
