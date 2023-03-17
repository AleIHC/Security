package com.generation.fisrtspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.fisrtspring.model.Usuario;
import com.generation.fisrtspring.model.UsuarioDTO;
import com.generation.fisrtspring.security.JwtUtil;
import com.generation.fisrtspring.security.MyAuthenticationManager;
import com.generation.fisrtspring.service.MyUserDetailsService;

import io.jsonwebtoken.Jwt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    //Clase de spring security que permite encriptar contraseña
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Inyección de dependencia del service donde está el método de crear usuario
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    //Inyectamos dependencia donde está el método para generar el token
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyAuthenticationManager authenticationManager;


    //Endpoint de registro 
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody UsuarioDTO usuarioDto) {
        String encryptedPassword = passwordEncoder.encode(usuarioDto.getPassword());
        usuarioDto.setPassword(encryptedPassword);
        Usuario usuarioRegistrado = myUserDetailsService.createUser(usuarioDto);
        return new ResponseEntity<>(usuarioRegistrado, HttpStatus.CREATED);
    }

    //Endpoint para logearse
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody UsuarioDTO usuarioDTO) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(usuarioDTO.getUsername(), usuarioDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userdetails = myUserDetailsService.loadUserByUsername(usuarioDTO.getUsername());
        String jwtToken = jwtUtil.generateToken(userdetails);

        return new ResponseEntity<>(new AuthResponseDTO(jwtToken), HttpStatus.OK);
    }



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthResponseDTO {
        private String jwtToken;
    }
    
}
