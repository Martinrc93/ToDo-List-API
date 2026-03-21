package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.task;

import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.task.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdaptar implements TaskRepositoryPort {

    private final TaskRepository taskRepository;
    //private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        return null;
    }
/*
    @Override
    public Optional<TaskEntity> findById(UUID id) {
        return taskRepository.findById(id);
    }

 */

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDomain).toList();
    }
}
