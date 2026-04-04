package com.martinc93.todolistapi.application.service.user;

import com.martinc93.todolistapi.application.ports.in.user.DeleteUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional
    public User execute(Long id) {
        return null;
    }
}
