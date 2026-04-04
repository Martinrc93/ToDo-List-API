package com.martinc93.todolistapi.domain.model.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Task {

    private Long id;

    private Long userId;

    private String title;

    private String description;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Task create(Long userId,String title, String description) {
        Task task = new Task();
        task.userId = userId;
        task.title = title;
        task.description = description;
        task.status = TaskStatus.PENDING;
        task.createdAt = LocalDateTime.now();
        task.updatedAt = LocalDateTime.now();

        return task;
    }

    public static Task update(Long id, String title, String description, TaskStatus status){
        Task task = new Task();
        task.id = id;
        task.title = title;
        task.description = description;
        task.status = status;
        task.updatedAt = LocalDateTime.now();

        return task;
    }

    /*
    public void assignToUser(UUID userId){
        if (userId != null){
            this.userId = userId;
        }
        throw new RuntimeException("User id is required"); //TODO: personalizar exepciones.
    }
    */

}
