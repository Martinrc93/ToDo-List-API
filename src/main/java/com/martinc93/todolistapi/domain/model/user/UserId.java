package com.martinc93.todolistapi.domain.model.user;

import java.util.UUID;

public record UserId(
        UUID value
){
    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
