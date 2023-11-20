package com.project.barbershop.repository;

import com.project.barbershop.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "select * from tb_appointment where date_appointment = :date and hour_appointment = :hour",
            nativeQuery = true)
    Optional<Appointment> findAvailableAppointment(@Param("date") LocalDate date, @Param("hour") LocalTime hour);

    List<Appointment> findAppointmentsByDateAppointment(LocalDate date);
}
