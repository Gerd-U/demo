package com.example.demo.facade;

import java.util.List;
import java.util.UUID;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;


public interface IUserFacade {
List<UserDto> getAll();

UserDto addUser(UserRequestDto userDto); 

UserDto updateUser(UUID resouceId, UserRequestDto userDto);

UserDto getByResourceId(UUID resourceId);

void removeUser(UUID resourceId);
}

