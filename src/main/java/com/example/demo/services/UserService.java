package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service  
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }  

    @Override
    public User addUser(UserRequestDto userDto) {
        var user = User
            .builder()
            .name(userDto.getName())  
            .resourceId(UUID.randomUUID())
            .build();
        return userRepository.addUser(user);
    }

    @Override
    public User updateUser(UUID resourceId, UserRequestDto userDto) {
        var user = userRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new RuntimeException("User no encontrado"));
        user.setName(userDto.getName());
        return userRepository.updateUser(user);
    }

    @Override
    public User getByResourceId(UUID resourceId) {
        return userRepository.findByResourceId(resourceId) 
            .orElseThrow(() -> new UserNotFoundException("User no encontrado"));
    }

    @Override
    public void removeUser(UUID resourceId) {
        var user = userRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new RuntimeException("User no encontrado"));
        userRepository.delete(user);
    }
}