package com.arthurlevi.reserva_salas_ufc_russas.repositories;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByIdUser(UUID idUser);
    List<Reservation> findByIdRoom(UUID idRoom);
}
