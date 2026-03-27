package com.martinc93.todolistapi.infrastructure.output.persistence.mapper.user;

import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User ToUser (UserEntity userEntity);

    UserEntity ToUserEntity (User user);

}
