package com.martinc93.todolistapi.domain.model.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import com.martinc93.todolistapi.domain.model.user.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task {

    private UUID id;

    private UUID userId;

    private String description;

    private String title;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /*
    public void assignToUser(UUID userId){
        if (userId != null){
            this.userId = userId;
        }
        throw new RuntimeException("User id is required"); //TODO: personalizar exepciones.
    }
    */

}
