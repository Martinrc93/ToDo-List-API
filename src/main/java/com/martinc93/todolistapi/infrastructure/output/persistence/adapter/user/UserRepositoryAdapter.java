package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.user;

import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        return entity.map(userMapper::ToUser).orElse(null);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
