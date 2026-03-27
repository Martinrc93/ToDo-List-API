package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.task;

import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.task.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task save(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);

        return taskMapper.toDomain(taskRepository.save(entity));
    }

    @Override
    public Task findById(Long id) {
        Optional<TaskEntity> entity = taskRepository.findById(id);
        return entity.map(taskMapper::toDomain).orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream().map(taskMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        return taskMapper.toDomain(taskRepository.save(entity));
    }
}
