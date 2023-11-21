package com.arthurlevi.reserva_salas_ufc_russas.resources;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Room;
import com.arthurlevi.reserva_salas_ufc_russas.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity findAll() {

        List<Room> rooms = roomService.findAll();
        return ResponseEntity.ok().body(rooms);
    }

    @PostMapping("/created")
    public ResponseEntity<Room> created(@RequestBody Room room){
        room = roomService.created(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
}
