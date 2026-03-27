package com.martinc93.todolistapi.domain.model.user;

public record UserId(
        Long value
){
    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
