package com.project.barbershop.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String description;
    @Lob
    private String image;
}
