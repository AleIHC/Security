package com.generation.fisrtspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.generation.fisrtspring.repository.EstudianteRepository;
import com.generation.fisrtspring.model.Estudiante;

@Service
@Transactional
public class EstudianteService {

    //se conecta con el erchivo repository para poder ocuparlo a nivel 
    //de las instrucciones creadas en esta
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }

    public void saveEstudiante(Estudiante estudiante){
        //este .save está haciendo el trabajo de in insert into,
        //pero java ya lo reconoce por defecto, entonces lo hará de manera automatica cuando
        //reconozca este método
        this.estudianteRepository.save(estudiante);
    }

    public void updateEstudiante(Estudiante estudiante){
        //apesar de ser una funcion de actualización se ocupa
        //el mismo metodo de guardardo
        this.estudianteRepository.save(estudiante);
    }

    public void deleteEstudiante(Integer id){
        estudianteRepository.deleteById(id);
    }

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public List<Estudiante> estudiantesConLL(){
        return estudianteRepository.findEstudiantesWithLL();
    }

    public List<Estudiante> estudiantePorEquipo(Integer equipo){
        return estudianteRepository.findEstudianteByEquipo(equipo);
    }

    
}
