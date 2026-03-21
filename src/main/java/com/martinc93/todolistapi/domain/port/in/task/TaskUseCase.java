package com.martinc93.todolistapi.domain.port.in.task;

import com.martinc93.todolistapi.domain.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TaskUseCase {

    Task create(Task task);

    Task getById(Long id);

    Page<Task> getList();

    Task update(Long id, Task task);

    void delete(Long id);

}