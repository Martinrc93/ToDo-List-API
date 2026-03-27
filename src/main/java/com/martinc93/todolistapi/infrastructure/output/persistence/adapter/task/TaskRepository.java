package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.task;

import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
