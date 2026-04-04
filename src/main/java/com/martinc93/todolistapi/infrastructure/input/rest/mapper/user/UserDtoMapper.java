package com.martinc93.todolistapi.infrastructure.input.rest.mapper.user;

import com.martinc93.todolistapi.application.ports.in.user.command.CreateUserCommand;
import com.martinc93.todolistapi.application.ports.in.user.command.UpdateUserCommand;
import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.CreateUserRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.UpdateUserRequestDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.request.user.UserDto;
import com.martinc93.todolistapi.infrastructure.input.rest.dto.response.user.UserReponseDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "Spring")
public interface UserDtoMapper {

    User toDomain (UserDto userDto);

    UserReponseDto toDto(User user);

    UpdateUserCommand toCommand(UpdateUserRequestDto requestDto);

    CreateUserCommand toCommand(CreateUserRequestDto requestDto);

}
