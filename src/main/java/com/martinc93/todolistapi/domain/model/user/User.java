package com.martinc93.todolistapi.domain.model.user;

import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;

    private List<Task> tasks;

    //TODO verificaciones.
    public static User createNewUser(String userName, String email, String password) {
        User user = new User();
        user.userName = userName;
        user.email = email;
        user.password = password;

        return user;
    }

    @Builder
    public static User create(Long id, String userName, String email){
        User user = new User();
        if (id !=null) user.id = id;
        if (userName !=null) user.userName = userName;
        if (email !=null) user.email = email;

        return user;
    }

    public void update(String username) {
        this.userName = username;
    }

    public String toString() {
        return this.id + " " + this.userName + " " + this.email + " ";
    }

}


