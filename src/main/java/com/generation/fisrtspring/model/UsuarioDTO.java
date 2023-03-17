package com.generation.fisrtspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Data transfer object que nos permite enviar información de una capa a otra sin comprometer  la seguridad
public class UsuarioDTO {
    
    private String username;
    private String password;
}
