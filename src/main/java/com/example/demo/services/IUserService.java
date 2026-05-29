package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;

public interface IUserService {

    List<User> getAll();
    User addUser(UserRequestDto userDto);
    User updateUser(Long id, UserRequestDto userDto);
    User getById(Long id);
    void removeUser(Long id);
}
