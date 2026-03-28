package com.martinc93.todolistapi.infrastructure.input.rest.controller;

import com.martinc93.todolistapi.application.ports.in.task.*;
import com.martinc93.todolistapi.application.usecase.task.CreateTaskService;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.CreateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.UpdateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task.TaskDto;
import com.martinc93.todolistapi.infrastructure.input.rest.mapper.task.TaskDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskService createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final TaskDtoMapper taskDtoMapper;


    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable long id){
        Task task = getTaskUseCase.getById(id);
        return ResponseEntity.ok(task.toString());
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Task>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return ResponseEntity.ok(getTaskUseCase.getAll(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> create(@RequestBody CreateTaskRequestDto taskRequestDto){
        TaskDto taskDto = taskDtoMapper.toDto(createTaskUseCase.execute(taskDtoMapper.toCommand(taskRequestDto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update (@RequestBody UpdateTaskRequestDto request){
        UpdateTaskCommand command = taskDtoMapper.toCommand(request);
        return ResponseEntity.ok(updateTaskUseCase.exucute(command));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete (@PathVariable Long id){
        deleteTaskUseCase.exucute(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
