package com.martinc93.todolistapi.infrastructure.input.rest.controller;

import com.martinc93.todolistapi.application.ports.in.task.GetTaskUseCase;
import com.martinc93.todolistapi.application.usecase.task.CreateTaskService;
import com.martinc93.todolistapi.application.usecase.task.GetTaskService;
import com.martinc93.todolistapi.domain.model.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    //private final CreateTaskService createTaskService;
    private final GetTaskService getTaskService;

    /*
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable UUID id){
        Task task = getTaskService.findById(id);
        return ResponseEntity.ok(task.toString());
    }
    */

    @GetMapping("/list")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok(getTaskService.getAll().toString());
    }
}
