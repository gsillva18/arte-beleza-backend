package com.project.barbershop.core.exceptions;

public class AppointmentNotfoundException extends Exception {

    public AppointmentNotfoundException(){
        super("Appointment not found");
    }
}
