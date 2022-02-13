package org.homework.igorr.core.converter;

import org.homework.igorr.core.dto.user.UserDto;
import org.homework.igorr.domain.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto map(User user);

    @Mapping(target = "version", ignore = true)
    User map(UserDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    void update(UserDto dto, @MappingTarget User target);
}
