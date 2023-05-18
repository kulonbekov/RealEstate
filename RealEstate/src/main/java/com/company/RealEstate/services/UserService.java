package com.company.RealEstate.services;

import com.company.RealEstate.models.dtos.UserDto;
import com.company.RealEstate.models.entities.User;

import java.util.List;

public interface UserService {

    UserDto register(UserDto userDto);

    List<UserDto> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    void delete(Long id);

    UserDto update(UserDto dto);
}
