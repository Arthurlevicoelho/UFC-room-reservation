package com.arthurlevi.reserva_salas_ufc_russas.services;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Room;
import com.arthurlevi.reserva_salas_ufc_russas.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room created(Room room){
        return roomRepository.save(room);

    }
}
