package com.project.barbershop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AppointmentDto {

    private LocalTime hour;
    private LocalDate date;
    private UserDto user;
}
