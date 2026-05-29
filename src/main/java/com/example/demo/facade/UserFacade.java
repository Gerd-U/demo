package com.example.demo.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.dtos.UserDto;
import com.example.demo.mappers.UserMapper;
import com.example.demo.services.UserService;

@Component
public class UserFacade implements IUserFacade {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userService.getAll());
    }

    @Override
    public UserDto addUser(UserRequestDto userDto) {
        var entity = userService.addUser(userDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto updateUser(UUID resourceId, UserRequestDto userDto) {
        var entity = userService.updateUser(resourceId, userDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto getByResourceId(UUID resourceId) {
        var entity = userService.getByResourceId(resourceId);
        return userMapper.toUserDto(entity);
    }

    @Override
    public void removeUser(UUID resourceId) {
        userService.removeUser(resourceId);
    }

}
