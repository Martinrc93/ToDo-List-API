package com.martinc93.todolistapi.infrastructure.input.rest.controller;

import com.martinc93.todolistapi.application.ports.in.task.command.UpdateTaskCommand;
import com.martinc93.todolistapi.application.ports.in.task.usecase.DeleteTaskUseCase;
import com.martinc93.todolistapi.application.ports.in.task.usecase.GetTaskUseCase;
import com.martinc93.todolistapi.application.ports.in.task.usecase.UpdateTaskUseCase;
import com.martinc93.todolistapi.application.service.task.CreateTaskService;
import com.martinc93.todolistapi.domain.model.task.Task;
import com.martinc93.todolistapi.domain.model.task.vo.TaskStatus;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.CreateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.task.UpdateTaskRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.task.TaskDto;
import com.martinc93.todolistapi.infrastructure.input.rest.mapper.task.TaskDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    public ResponseEntity<TaskDto> getById(@PathVariable Long id){
        return getTaskUseCase.getById(id)
                .map(taskDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<Page<TaskDto>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable){

        Page<TaskDto> response = getTaskUseCase.getAll(pageable).map(taskDtoMapper::toDto);

        if (!response.isEmpty()){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{taskStatus}")
    public ResponseEntity<Page<TaskDto>> getByStatus(@PageableDefault(size = 10, page = 0) Pageable pageable,
                                                     @PathVariable TaskStatus taskStatus){
        Page<TaskDto> response = getTaskUseCase.getByStatus(taskStatus, pageable).map(taskDtoMapper::toDto);
        if (!response.isEmpty()){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/updated")
    public ResponseEntity<Page<TaskDto>> getByUpdatedAt(@PageableDefault(size = 10,page = 0) Pageable pageable,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to){
        Page<TaskDto> response = getTaskUseCase.getByUpdatedAt(from, to, pageable).map(taskDtoMapper::toDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
