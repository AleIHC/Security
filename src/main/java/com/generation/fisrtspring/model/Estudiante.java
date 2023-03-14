package com.generation.fisrtspring.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//el entity nos permite decirle al objeto que hará referencia a una tabla
//ademas le podemos entregar el nombre de la tabla de manera explicita
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="estudiantes")
public class Estudiante {
    //estos dos datos no permiten espicificarle a la base que el siguente atributo es el id de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estudiante_id;
    private String nombre;
    private String apellido;
    private Integer equipo_id;

}
