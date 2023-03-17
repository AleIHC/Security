package com.generation.fisrtspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.fisrtspring.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    //Encontrar el usuario por username
    Usuario findUserByUsername(String username);
}
