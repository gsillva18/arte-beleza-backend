package com.project.barbershop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private Long id;
    private String name;
    private Integer age;
    private String description;
    private String image;
}
