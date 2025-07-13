package com.manuel.usuario_api.repository;

import com.manuel.usuario_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}
