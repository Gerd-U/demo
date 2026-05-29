package com.example.demo.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.mappers.UserMapper;
import com.example.demo.services.IUserService;

@Component
public class UserFacade implements IUserFacade {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        return userMapper.toUserDtoList(userService.getAll());
    }

    @Override
    @Transactional
    public UserDto addUser(UserRequestDto userDto) {
        var entity = userService.addUser(userDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, UserRequestDto userDto) {
        var entity = userService.updateUser(id, userDto);
        return userMapper.toUserDto(entity);
    }

    @Override
    public UserDto getById(Long id) {
        var entity = userService.getById(id);
        return userMapper.toUserDto(entity);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userService.removeUser(id);
    }
}
