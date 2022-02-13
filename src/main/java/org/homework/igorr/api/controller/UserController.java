package org.homework.igorr.api.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.homework.igorr.core.dto.user.*;
import org.homework.igorr.core.service.impl.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;

    @PostMapping("/user/get")
    public UserResponseDto getUser(@Valid @RequestBody UserRequestDto request) {
        return service.findById(request);
    }

    @PostMapping("/user")
    public UserResponseDto createUser(@Valid @RequestBody UserCreateDto request) {
        return service.create(request);
    }

    @PutMapping("/user")
    public UserResponseDto updateUser(@Valid @RequestBody UserUpdateDto request) {
        return service.update(request);
    }

    @PostMapping("/user/delete")
    public UserResponseDto deleteUser(@Valid @RequestBody UserDeleteDto request) {
        return service.delete(request);
    }


    @GetMapping("/user/get/{id}")
    public UserDto getUser(@PathVariable Long id){
        return service.findById(id);
    }
}
