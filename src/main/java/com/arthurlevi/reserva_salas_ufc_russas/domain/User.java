package com.arthurlevi.reserva_salas_ufc_russas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String username;
    private Integer registration;
    private String email;
    private String password;
}
