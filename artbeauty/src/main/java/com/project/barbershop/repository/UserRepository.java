package com.project.barbershop.repository;

import com.project.barbershop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String name);
}
