package com.martinc93.todolistapi.application.ports.in.user;

import com.martinc93.todolistapi.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GetUserUseCase {

         User get (Long id);

        Page<User> list (Pageable pageable);
}
