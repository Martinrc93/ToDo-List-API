package com.martinc93.todolistapi.infrastructure.input.rest.mapper.task;

import com.martinc93.todolistapi.application.ports.in.task.CreateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.UpdateTaskCommand;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.CreateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.UpdateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    TaskDto toDto(Task task);

    CreateTaskCommand toCommand(CreateTaskRequestDto taskRequestDto);

    UpdateTaskCommand toCommand(UpdateTaskRequestDto taskRequestDto);
}
