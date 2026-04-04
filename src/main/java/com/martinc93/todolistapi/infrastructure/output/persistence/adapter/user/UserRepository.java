package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.user;

import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByEmail(String email);
}
