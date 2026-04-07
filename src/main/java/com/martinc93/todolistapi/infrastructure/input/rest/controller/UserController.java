package com.martinc93.todolistapi.infrastructure.input.rest.controller;

import com.martinc93.todolistapi.application.ports.in.user.command.UpdateUserCommand;
import com.martinc93.todolistapi.application.service.user.CreateUserService;
import com.martinc93.todolistapi.application.service.user.DeleteUserService;
import com.martinc93.todolistapi.application.service.user.GetUserService;
import com.martinc93.todolistapi.application.service.user.UpdateUserService;
import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.CreateUserRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.UpdateUserRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.UserDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.user.UserReponseDto;
import com.martinc93.todolistapi.infrastructure.input.rest.mapper.user.UserDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController{

    private final GetUserService getUserService;
    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final UserDtoMapper userDtoMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserReponseDto> findById(@PathVariable Long id){
        return getUserService.get(id)
                .map(userDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserReponseDto> findByUsername(@PathVariable String username){
        return getUserService.getByUserName(username)
                .map(userDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserReponseDto> findByEmail(@PathVariable String email) {
        return getUserService.getByEmail(email)
                .map(userDtoMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<Page<UserReponseDto>> listUsers (@PageableDefault(size = 10, page = 0)
                                                      Pageable pageable){
        Page<UserReponseDto> page = getUserService.list(pageable).map(userDtoMapper::toDto);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/")
    public ResponseEntity<UserReponseDto> createUser(@RequestBody CreateUserRequestDto userDto){

        UserReponseDto userResponse = userDtoMapper.toDto(createUserService.execute(userDtoMapper.toCommand(userDto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PutMapping("/")
    public ResponseEntity<UserReponseDto> updateUser(@Valid @RequestBody UpdateUserRequestDto request) {

        UpdateUserCommand command = userDtoMapper.toCommand(request);
        User updatedUser = updateUserService.execute(command);
        UserReponseDto userResponse = userDtoMapper.toDto(updatedUser);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        deleteUserService.execute(id);
        return ResponseEntity.noContent().build();
    }

}
