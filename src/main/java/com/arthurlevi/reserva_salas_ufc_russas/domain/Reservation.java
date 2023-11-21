package com.arthurlevi.reserva_salas_ufc_russas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_reservations")
public class Reservation {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private LocalDateTime startAt;

    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private LocalDateTime endAt;


    private UUID idRoom;

    private UUID idUser;

}
