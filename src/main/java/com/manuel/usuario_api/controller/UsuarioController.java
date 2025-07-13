package com.manuel.usuario_api.controller;


import com.manuel.usuario_api.model.Usuario;
import com.manuel.usuario_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin(origins = {
    "http://localhost:4200",
    "https://usuario-frontend.1.onrender.com"
})
@RestController // Indica que esta clase expone rutas HTTP (API REST)
@RequestMapping("/api/usuarios")  // Todas las rutas empezarán por /api/usuarios
public class UsuarioController {

    @Autowired // Inyección automática del repositorio
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        // Devuelve todos los usuarios
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {
        // Guarda el usuario recibido por JSON
        return usuarioRepository.save(usuario);
    }
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id,@Valid @RequestBody Usuario datosNuevos) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombre(datosNuevos.getNombre());
        usuarioExistente.setCorreo(datosNuevos.getCorreo());

        return usuarioRepository.save(usuarioExistente);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
