package com.martinc93.todolistapi.infrastructure.output.persistence.mapper.user;

import com.martinc93.todolistapi.domain.model.user.User;
import com.martinc93.todolistapi.infrastructure.output.persistence.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain (UserEntity userEntity);

    UserEntity toEntity (User user);

    @Mapping(target = "password",ignore = true)
    void updateEntity(User user, @MappingTarget UserEntity entity);

}
