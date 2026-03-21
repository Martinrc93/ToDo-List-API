package com.martinc93.todolistapi.domain.model.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private UserId id;
    private String username;
    private String email;
    private String password;

}
