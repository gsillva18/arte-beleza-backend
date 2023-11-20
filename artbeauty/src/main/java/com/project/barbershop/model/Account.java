package com.project.barbershop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @Column(name = "number_of_cuts")
    private Integer numberOfCuts;
}
