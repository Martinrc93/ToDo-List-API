package com.martinc93.todolistapi.infrastructure.output.persistence.entity.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private Long userId;

    @Column()//length = 50, nullable = false
    private String title;

    @Column()//length = 255, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column()//nullable = false
    private TaskStatus status;

    @Column(name = "created") //, nullable = false, updatable = false
    private LocalDateTime createdAt;

    @Column(name = "updated")
    private LocalDateTime updatedAt;

    /*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

     */

}