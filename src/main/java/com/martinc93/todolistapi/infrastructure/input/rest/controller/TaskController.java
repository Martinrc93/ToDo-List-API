package com.martinc93.todolistapi.infrastructure.input.rest.controller;

import com.martinc93.todolistapi.application.ports.in.task.CreateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.DeleteTaskUseCase;
import com.martinc93.todolistapi.application.ports.in.task.GetTaskUseCase;
import com.martinc93.todolistapi.application.ports.in.task.UpdateTaskUseCase;
import com.martinc93.todolistapi.application.usecase.task.CreateTaskService;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.TaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task.TaskDto;
import com.martinc93.todolistapi.infrastructure.input.rest.mapper.task.TaskDtoMapper;
import com.martinc93.todolistapi.infrastructure.output.persistence.mapper.task.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(getTaskUseCase.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> create(@RequestBody TaskRequestDto taskRequestDto){
        CreateTaskCommand command = taskDtoMapper.toCommand(taskRequestDto);
        Task task = createTaskUseCase.execute(command);
        TaskDto taskDto = taskDtoMapper.toDto(task);
        System.out.println("Tittle :" + task.getTitle()+ "Id" + task.getUserId());
        System.out.println(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update (@RequestBody Task task){
        return ResponseEntity.ok(updateTaskUseCase.exucute(task));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Task> delete (@RequestBody Long id){
        return ResponseEntity.ok(deleteTaskUseCase.exucute(getTaskUseCase.getById(id)));
    }


}
