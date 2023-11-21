package com.arthurlevi.reserva_salas_ufc_russas;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.arthurlevi.reserva_salas_ufc_russas.repositories.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterReservationAuth extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //pegando o caminho pelo qual a requisição esta vindo
        var servletPath = request.getServletPath();

        if(servletPath.startsWith("/reservation")){
            var authorization = request.getHeader("Authorization");
            var authEncoded = authorization.substring("Basic".length()).trim();
            byte [] authDecode = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecode);

            String[] usersCredentials = authString.split(":");
            String username = usersCredentials[0];
            String password = usersCredentials[1];

            var user = this.userRepository.findByUsername(username);
            if(user == null){
                response.sendError(401);
            }else {
                var paswordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (paswordVerify.verified) {
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);

                }
            }

        }else{
                filterChain.doFilter(request,response);
            }


        }
}
