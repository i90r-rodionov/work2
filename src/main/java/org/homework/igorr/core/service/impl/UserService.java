package org.homework.igorr.core.service.impl;

import org.homework.igorr.core.dto.user.*;

public interface UserService {

    UserResponseDto findById(UserRequestDto request);

    UserDto findById(Long id);

    UserResponseDto create(UserCreateDto request);

    UserResponseDto update(UserUpdateDto request);

    UserResponseDto delete(UserDeleteDto request);
}
