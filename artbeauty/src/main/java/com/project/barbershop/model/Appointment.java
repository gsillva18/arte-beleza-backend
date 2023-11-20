package com.project.barbershop.model;

import com.project.barbershop.core.enums.StatusAppointment;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "TB_APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;
    @Column(name = "hour_appointment")
    private LocalTime hourAppointment;
    @Column(name = "date_appointment")
    private LocalDate dateAppointment;
    @Enumerated(EnumType.STRING)
    private StatusAppointment status;
}
