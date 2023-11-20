package com.project.barbershop.core.util;

import com.project.barbershop.core.enums.StatusAppointment;
import com.project.barbershop.model.Appointment;
import com.project.barbershop.model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreatorModel {

    public static Appointment createAppointment(LocalDate date, LocalTime hour, User user){
        Appointment appointment = new Appointment();
        appointment.setDateAppointment(date);
        appointment.setHourAppointment(hour);
        appointment.setStatus(StatusAppointment.UNAVAILABLE);
        appointment.setUser(user);

        return appointment;
    }
}
