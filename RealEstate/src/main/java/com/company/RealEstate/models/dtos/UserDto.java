package com.company.RealEstate.models.dtos;

import com.company.RealEstate.models.entities.Role;
import com.company.RealEstate.models.enums.Gender;

import java.util.List;

public class UserDto extends BaseDto{

    String username;
    String email;
    String password;
    Gender gender;
    int yearOfBirth;
    List<Role> roles;
}
