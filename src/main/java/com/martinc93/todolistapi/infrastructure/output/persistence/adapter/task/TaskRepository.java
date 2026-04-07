package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.task;

import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    Page<TaskEntity> findBystatus(TaskStatus taskStatus, Pageable pageable);

    @Query("SELECT t FROM TaskEntity t WHERE t.updatedAt >= :from AND t.updatedAt <= :to")
    Page<TaskEntity> finbByupdatedAt (LocalDateTime from,LocalDateTime to, Pageable pageable);

    @Query("SELECT t FROM TaskEntity t WHERE t.user.id = :userId AND t.status != 'DONE'")
    Page<TaskEntity> findByUserId(Long userId, Pageable pageable);

}
