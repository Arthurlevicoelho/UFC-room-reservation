package com.arthurlevi.reserva_salas_ufc_russas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_rooms")
public class Room {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private Integer number;
    private Integer capacity;
    private Integer status;

}
