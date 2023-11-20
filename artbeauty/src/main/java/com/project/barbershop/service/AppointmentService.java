package com.project.barbershop.service;

import com.project.barbershop.core.enums.StatusAppointment;
import com.project.barbershop.core.exceptions.AppointmentHourUnavailable;
import com.project.barbershop.core.exceptions.AppointmentNotfoundException;
import com.project.barbershop.core.util.CreatorModel;
import com.project.barbershop.dto.AppointmentDateDto;
import com.project.barbershop.dto.AppointmentIdDto;
import com.project.barbershop.dto.AppointmentDto;
import com.project.barbershop.model.Appointment;
import com.project.barbershop.model.User;
import com.project.barbershop.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public void makeAnAppointment(AppointmentDto dto) throws Exception{
        //verifica se o appointment está livre para a data e hora específica
        if(repository.findAvailableAppointment(dto.getDate(), dto.getHour()).isPresent()){
            throw new AppointmentHourUnavailable();
        }
        //verificar se o usuário já existe, senão cria e retorna ele
        User user = userService.createUser(dto.getUser());
        //criar e salvar appointment, colocado como status ocupado (UNAVAILABLE)
        repository.save(CreatorModel.createAppointment(dto.getDate(), dto.getHour(), user));
    }

    public void finalizeAppointment(AppointmentIdDto dto) throws Exception{
        Appointment appointment = searchAppointment(dto);
        appointment.setStatus(StatusAppointment.CONCLUDED);
        repository.save(appointment);
        accountService.increaseNumberOfCuts(appointment.getUser());
    }

    public Appointment searchAppointment(AppointmentIdDto dto) throws Exception{
        return repository.findById(dto.getId()).orElseThrow(() -> new AppointmentNotfoundException());
    }

    public void cancelAppointment(AppointmentIdDto dto) throws Exception{
        //verifica a existencia do appointment pelo seu id
        //se existir, deleta ele do banco
        repository.delete(searchAppointment(dto));
    }

    public List<Appointment> searchAppointments(AppointmentDateDto dto){
        //busca os appointments de uma data específica
        return repository.findAppointmentsByDateAppointment(dto.getDate());
    }
}
