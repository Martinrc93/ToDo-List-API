package com.martinc93.todolistapi.application.usecase.user;

import com.martinc93.todolistapi.application.ports.in.user.GetUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User get(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public Page<User> list(Pageable pageable) {
        return null;
    }
}
