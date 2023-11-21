package com.arthurlevi.reserva_salas_ufc_russas.repositories;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

}
