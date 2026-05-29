package com.example.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.entities.User;
import com.example.demo.models.UserRequestModel;
import com.example.demo.models.UserResponseModel;


@Component
public class UserMapper {

    public UserDto toUserDto(User user) {  // ← retornaba User en vez de UserDto
        if (user == null) {
            return null;
        }
        return new UserDto(user.getResourceId(), user.getName());
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
            .map(this::toUserDto)
            .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return new UserResponseModel(userDto.resourceID(), userDto.name());
    }

    public List<UserResponseModel> toUserResponseModelList(List<UserDto> userDtos) {
        if (userDtos == null) {
            return null;
        }
        return userDtos.stream()
            .map(this::toUserResponseModel)
            .collect(Collectors.toList());
    }

    public UserRequestDto toUserRequestDto(UserRequestModel user) {
        if (user == null) {
            return null;
        }
        UserRequestDto userDto = new UserRequestDto(); 
        userDto.setName(user.name());
        return userDto;
    }
}