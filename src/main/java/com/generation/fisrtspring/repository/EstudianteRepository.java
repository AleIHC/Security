package com.generation.fisrtspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.fisrtspring.model.Estudiante;

//Vas a crear un archivo repositorio en donde cuando te conectes a la base
//vas a trabajar con oibjetos de tipo estudiante el tiene un ID de tipo Integer
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    //esta es una query nativa, sin parámetros que nos permite obtener
    //los estudiantes que tengan una "ll" en su nombre
    //es una consulta personalizada
    @Query(value = "SELECT * FROM estudiantes WHERE nombre like ('%ll%')", nativeQuery=true)
    List <Estudiante> findEstudiantesWithLL();

    //Esta es tambien otra query nativa, con parámetros que nos permite
    //obtener los atudiantes perteniecientes a un equipo el cual
    //yo voy a especificar cuando llame a esta consulta
    //tambien es una consulta personalizada
    //@Query(value = "SELECT * FROM estudiantes WHERE equipo_id = ?1 AND nombre = ?2", nativeQuery = true)
    //List <Estudiante> findEstudianteByEquipo(Integer equipo, String nombre);
    
    @Query(value = "SELECT * FROM estudiantes WHERE equipo_id = ?1", nativeQuery = true)
    List <Estudiante> findEstudianteByEquipo(Integer equipo);

    //como hacer una funcion de modificacion en querys nativas
    //ojo este ejemplo es de otro proyecto
    /*@Modifying
    @Query(value = "UPDATE PRODUCT p SET p.STOCK = p.stock+10 WHERE p.id = ?1", nativeQuery = true)
    void sumarStock(Long recetaID);*/
}
