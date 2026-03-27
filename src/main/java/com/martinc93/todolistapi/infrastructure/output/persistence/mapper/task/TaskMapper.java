package com.martinc93.todolistapi.infrastructure.output.persistence.mapper.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.task.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    //@Mapping(source = "userId" , target = "user")
    TaskEntity toEntity(Task task);

    Task toDomain(TaskEntity entity);

}
