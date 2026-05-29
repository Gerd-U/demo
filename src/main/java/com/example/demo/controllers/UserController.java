package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDto;
import com.example.demo.facade.IUserFacade;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.UserRequestModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userFacade.getAll());
    }

    @PostMapping
    public UserDto save(@Valid @RequestBody UserRequestModel userRequestModel) {
        var dto = userMapper.toUserRequestDto(userRequestModel);
        return userFacade.addUser(dto);
    }

    @PutMapping(path = "/{id}")
    public UserDto update(@PathVariable("id") Long id,
            @Valid @RequestBody UserRequestModel userRequestModel) {
        var dto = userMapper.toUserRequestDto(userRequestModel);
        return userFacade.updateUser(id, dto);
    }

    @GetMapping(path = "/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return userFacade.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void remove(@PathVariable("id") Long id) {
        userFacade.removeUser(id);
    }
}
