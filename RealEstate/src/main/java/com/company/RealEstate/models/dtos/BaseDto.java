package com.company.RealEstate.models.dtos;

import com.company.RealEstate.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseDto {
    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date created;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date updated;
    Status status;
}
