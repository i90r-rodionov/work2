package org.homework.igorr.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.homework.igorr.core.converter.UserMapper;
import org.homework.igorr.core.dto.user.*;
import org.homework.igorr.core.exception.UserNotFindException;
import org.homework.igorr.domain.entity.user.User;
import org.homework.igorr.domain.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserResponseDto findById(UserRequestDto request) {
        User user = repository.findById(request.getId()).get();
        UserDto dto = UserMapper.INSTANCE.map(user);
        return UserResponseDto.success(dto, request.getRqId());
    }

    @Transactional
    @Override
    public UserResponseDto create(UserCreateDto request) {
        User user = UserMapper.INSTANCE.map(request.getUserDto());
        repository.saveAndFlush(user);
        UserDto dto = UserMapper.INSTANCE.map(user);
        return UserResponseDto.success(dto, request.getRqId());
    }

    @Transactional
    @Override
    public UserResponseDto update(UserUpdateDto request) {
        Optional<User> user = repository.findUserWithLock(request.getUserDto().getId());
        if (user.isEmpty()) {
            return UserResponseDto.error(request.getRqId(),
                    new UserNotFindException("User not found for id=" + request.getUserDto().getId()));
        }
        UserMapper.INSTANCE.update(request.getUserDto(), user.get());

        UserDto dto = UserMapper.INSTANCE.map(user.get());
        return UserResponseDto.success(dto, request.getRqId());
    }

    @Transactional
    @Override
    public UserResponseDto delete(UserDeleteDto request) {
        Optional<User> user = repository.findUserWithLock(request.getId());
        if (user.isEmpty()) {
            return UserResponseDto.error(request.getRqId(),
                    new UserNotFindException("User not found for id=" + request.getId()));
        }
        repository.deleteById(request.getId());
        UserDto dto = new UserDto();
        return UserResponseDto.success(dto, request.getRqId());
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }


}
