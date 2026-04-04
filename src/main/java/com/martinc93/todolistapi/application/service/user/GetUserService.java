package com.martinc93.todolistapi.application.service.user;

import com.martinc93.todolistapi.application.ports.in.user.GetUserUseCase;
import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    @Transactional(readOnly = true)
    public Optional<User> get(Long id) {
        Optional<User> user = userRepositoryPort.findById(id);
        return userRepositoryPort.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> list(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByUserName(String userName) {
        return userRepositoryPort.findByUserName(userName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByEmail(String email) {
        return userRepositoryPort.findByEmail(email);
    }
}
