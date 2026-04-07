package com.martinc93.todolistapi.infrastructure.output.persistence.adapter.task;

import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.task.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    @Transactional
    public Task save(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        return taskMapper.toDomain(taskRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {
        Optional<TaskEntity> entity = taskRepository.findById(id);
        return entity.map(taskMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Task> findAll(Pageable pageable) {
        Page<TaskEntity> tasks = taskRepository.findAll(pageable);
        return tasks.map(taskMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Task> findByTaskStatus(TaskStatus taskStatus, Pageable pageable) {
        return taskRepository.findBystatus(taskStatus, pageable).map(taskMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Task> findByUpdatedAt(LocalDateTime from, LocalDateTime to,Pageable pageable) {
        return taskRepository.finbByupdatedAt(from, to,pageable).map(taskMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Task> findByUserId(Long userId, Pageable pageable) {
        return taskRepository.findByUserId(userId, pageable).map(taskMapper::toDomain);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        return taskMapper.toDomain(taskRepository.save(entity));
    }
}
