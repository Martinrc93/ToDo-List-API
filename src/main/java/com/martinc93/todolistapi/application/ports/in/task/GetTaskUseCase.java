package com.martinc93.todolistapi.application.ports.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetTaskUseCase {

    Task getById(Long id);

    Page<Task> getAll(Pageable pageable);

}
