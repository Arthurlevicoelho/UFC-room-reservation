package com.arthurlevi.reserva_salas_ufc_russas.resources;

import com.arthurlevi.reserva_salas_ufc_russas.domain.User;
import com.arthurlevi.reserva_salas_ufc_russas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {

        List<User> usersList = this.service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    @PostMapping("/")
    public ResponseEntity created(@RequestBody User user){
        user = this.service.created(user);
        if(user == null){
            return ResponseEntity.badRequest().body("O usuario já existe");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}