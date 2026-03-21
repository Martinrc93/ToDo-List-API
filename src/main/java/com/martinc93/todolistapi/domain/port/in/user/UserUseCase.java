package com.martinc93.todolistapi.domain.port.in.user;

import com.martinc93.todolistapi.domain.model.user.User;
import org.springframework.data.domain.Page;

public interface UserUseCase {

    User create(User user);

    User getById(Long id);

    Page<User> getList();

    User update(Long id, User user);

    void delete(Long id);

}
