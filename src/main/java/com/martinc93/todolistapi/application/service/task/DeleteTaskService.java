package com.martinc93.todolistapi.application.service.task;

import com.martinc93.todolistapi.application.ports.in.task.usecase.DeleteTaskUseCase;
import com.martinc93.todolistapi.application.ports.out.task.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTaskService implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public void exucute(Long id) {
        taskRepositoryPort.deleteById(id);
    }
}
