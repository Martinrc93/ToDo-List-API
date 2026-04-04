package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.user;

import com.martinc93.todolistapi.application.ports.out.user.UserRepositoryPort;
import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUserName(username).map(userMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDomain);
    }

    @Override
    @Transactional
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        return userMapper.toDomain(userRepository.save(userEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        UserEntity entity = userRepository.findById(id).get();
        return userRepository.findById(id).map(userMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDomain);
    }

    @Override
    @Transactional
    public User update(User user) {

        UserEntity userEntity = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("Not found user witch id : " + user.getId()));

        userMapper.updateEntity(user, userEntity);

        UserEntity updatedEntity = userRepository.save(userEntity);

        return userMapper.toDomain(updatedEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
