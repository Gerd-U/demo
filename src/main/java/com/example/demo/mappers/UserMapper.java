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

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getName(), user.getAge());
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }

    public UserResponseModel toUserResponseModel(UserDto userDto, Long id) {
        if (userDto == null) {
            return null;
        }
        return new UserResponseModel(id, userDto.name(), userDto.age());
    }

    public List<UserResponseModel> toUserResponseModelList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(u -> new UserResponseModel(u.getId(), u.getName(), u.getAge()))
                .collect(Collectors.toList());
    }

    public UserRequestDto toUserRequestDto(UserRequestModel model) {
        if (model == null) {
            return null;
        }
        UserRequestDto dto = new UserRequestDto();
        dto.setName(model.name());
        dto.setAge(model.age());
        return dto;
    }
}
