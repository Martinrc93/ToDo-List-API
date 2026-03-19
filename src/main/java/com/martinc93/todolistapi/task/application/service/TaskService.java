package com.martinc93.todolistapi.task.application.service;

import com.martinc93.todolistapi.task.infrastructure.input.dto.TaskDto;
import org.springframework.data.domain.Page;

public class TaskService implements ITaskService {

    @Override
    public TaskDto create(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskDto getTask(Long id) {
        return null;
    }

    @Override
    public Page<TaskDto> getList() {
        return null;
    }

    @Override
    public TaskDto update(Long id, TaskDto taskDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
