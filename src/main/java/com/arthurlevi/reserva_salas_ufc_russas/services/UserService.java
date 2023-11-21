package com.arthurlevi.reserva_salas_ufc_russas.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.arthurlevi.reserva_salas_ufc_russas.domain.User;
import com.arthurlevi.reserva_salas_ufc_russas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> findAll(){

        return this.userRepository.findAll();
    }

    public User created(User user){
        var validate = this.userRepository.findByUsername(user.getUsername());

        if(validate != null){
            return null;
        }
        var passwordHashred =  BCrypt.withDefaults().hashToString(12,user.getPassword().toCharArray());
        user.setPassword(passwordHashred);

        return this.userRepository.save(user);
    }
}
