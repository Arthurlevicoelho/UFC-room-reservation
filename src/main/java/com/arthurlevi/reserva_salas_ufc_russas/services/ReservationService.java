package com.arthurlevi.reserva_salas_ufc_russas.services;

import com.arthurlevi.reserva_salas_ufc_russas.domain.Reservation;
import com.arthurlevi.reserva_salas_ufc_russas.domain.Room;
import com.arthurlevi.reserva_salas_ufc_russas.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation created(Reservation reservation) {

        List<Reservation> Rooms = this.reservationRepository.findByIdRoom(reservation.getIdRoom());
        LocalDateTime now = LocalDateTime.now();
        for (Reservation reservationByRoom : Rooms){//Conferindo se a hora já nao esta reservada no sistema
            var start = reservationByRoom.getStartAt();
            var end = reservationByRoom.getEndAt();

            if(reservation.getStartAt().isAfter(start) && reservation.getStartAt().isBefore(end) ||
                    reservation.getEndAt().isAfter(start) && reservation.getEndAt().isBefore(end) ||
                    reservation.getStartAt().equals(start) || reservation.getEndAt().equals(end)){

                return null;
            }
        }
        if(reservation.getStartAt().isAfter(now) && reservation.getEndAt().isAfter(now)
                && reservation.getStartAt().isBefore(reservation.getEndAt()) && !reservation.getStartAt().equals(reservation.getEndAt())){
            return reservationRepository.save(reservation);
        }else {
            return null;
        }
    }
    public List<Reservation> findByIdUser(UUID idUser){
        return this.reservationRepository.findByIdUser(idUser);
    }

    public List<Reservation> findByIdRoom(UUID idRoom){

        return this.reservationRepository.findByIdRoom(idRoom);
    }

    public void deleteById(UUID id){
        this.reservationRepository.deleteById(id);
    }

}
