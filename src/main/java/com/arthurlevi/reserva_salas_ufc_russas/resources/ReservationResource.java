package com.arthurlevi.reserva_salas_ufc_russas.resources;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Reservation;
import com.arthurlevi.reserva_salas_ufc_russas.services.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationResource {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> findAll(){
        List<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping("/")
    public ResponseEntity created(@RequestBody Reservation reservation, HttpServletRequest request){

        var idUser = request.getAttribute("idUser");
        reservation.setIdUser((UUID) idUser);

        var reservationCreated = reservationService.created(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationCreated);
    }

    @GetMapping("/findByIdUser")
    public ResponseEntity findByIdUser(HttpServletRequest request){

        var idUser = request.getAttribute("idUser");
        var listReservationByIdUser = this.reservationService.findByIdUser((UUID) idUser);
        return ResponseEntity.ok().body(listReservationByIdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity findByIdRoom(@PathVariable UUID id){


        var listByIdRoom = this.reservationService.findByIdRoom(id);

        return ResponseEntity.ok().body(listByIdRoom);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable UUID id){
        this.reservationService.deleteById(id);//logica para deletar reserva

        return ResponseEntity.noContent().build();
    }

}
