package com.martinc93.todolistapi.domain.model.user;

import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;

    private List<Task> tasks;

}
