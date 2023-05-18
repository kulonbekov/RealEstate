package com.company.RealEstate.models.entities;

import com.company.RealEstate.models.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_user")
public class User extends BaseEntity{

    @Column(name = "username", unique = true)
    @NotNull()
    String username;

    @Column(name = "email", unique = true)
    @NotNull()
    String email;

    @Column(name = "password")
    @NotNull()
    String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;

    @Column(name = "year_of_birth")
    @NotNull()
    int yearOfBirth;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
