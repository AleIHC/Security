package com.generation.fisrtspring.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="equipos")
public class Equipo {

    @Id
    @GeneratedValue
    private Integer equipo_id;
    private String nombre_proyecto;
    private Integer integrantes;

    
}
