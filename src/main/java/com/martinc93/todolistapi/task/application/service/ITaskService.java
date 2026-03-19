package com.martinc93.todolistapi.task.application.service;

import com.martinc93.todolistapi.task.infrastructure.input.dto.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {

    TaskDto create(TaskDto taskDto);

    TaskDto getTask(Long id);

    Page<TaskDto> getList();

    TaskDto update(Long id,TaskDto taskDto);

    void delete(Long id);

}