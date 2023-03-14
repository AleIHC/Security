package com.generation.fisrtspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "nombre_usuario")
    @Range(min = 5, message = "Debe introducir mínimo 5 caractéres")
    private String nombreDeUsuario;

    @Column(name = "email_usuario")
    @Email
    private String email;

    @Range(min = 8, message = "Debe introducir mínimo 8 caractéres")
    private String password;

    
}
