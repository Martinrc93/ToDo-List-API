package com.martinc93.todolistapi.application.ports.out.user;

import com.martinc93.todolistapi.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    Page<User> findAll(Pageable pageable);
    User update(User user);
    void deleteById(Long id);

}
