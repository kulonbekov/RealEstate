package com.company.RealEstate.models.entities;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_role")
public class Role extends BaseEntity{

    @NotNull
    @Column(name = "name", unique = true)
    String name;


}
