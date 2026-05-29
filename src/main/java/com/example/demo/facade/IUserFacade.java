package com.example.demo.facade;

import java.util.List;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;

public interface IUserFacade {

    List<UserDto> getAll();
    UserDto addUser(UserRequestDto userDto);
    UserDto updateUser(Long id, UserRequestDto userDto);
    UserDto getById(Long id);
    void removeUser(Long id);
}
