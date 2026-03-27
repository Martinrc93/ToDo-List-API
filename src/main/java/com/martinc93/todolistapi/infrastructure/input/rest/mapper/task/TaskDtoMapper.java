package com.martinc93.todolistapi.infrastructure.input.rest.mapper.task;

import com.martinc93.todolistapi.application.ports.in.task.CreateTaskCommand;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.TaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    TaskDto toDto(Task task);

    CreateTaskCommand toCommand(TaskRequestDto taskRequestDto);
}
