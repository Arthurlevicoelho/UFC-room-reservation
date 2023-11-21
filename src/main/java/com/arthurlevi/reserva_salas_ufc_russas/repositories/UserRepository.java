package com.arthurlevi.reserva_salas_ufc_russas.repositories;

import com.arthurlevi.reserva_salas_ufc_russas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String name);
}
