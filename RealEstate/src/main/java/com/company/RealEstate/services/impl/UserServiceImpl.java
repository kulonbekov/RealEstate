package com.company.RealEstate.services.impl;

import com.company.RealEstate.mappers.UserMapper;
import com.company.RealEstate.models.dtos.UserDto;
import com.company.RealEstate.models.entities.Role;
import com.company.RealEstate.models.entities.User;
import com.company.RealEstate.models.enums.Status;
import com.company.RealEstate.repository.RoleRep;
import com.company.RealEstate.repository.UserRep;
import com.company.RealEstate.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRep userRep;
    private final RoleRep roleRep;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDto register(UserDto userDto) {
        return userMapper.toDto(userRep.save(toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtos(userRep.findAll());
    }

    @Override
    public User findByUsername(String username) {
        return userRep.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRep.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRep.findById(id).orElseThrow(() -> new RuntimeException("User is not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDto update(UserDto dto) {
        return null;
    }

    private User toEntity(UserDto userDto) {


        Role roleUser = roleRep.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setYearOfBirth(userDto.getYearOfBirth());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        return user;
    }
}
