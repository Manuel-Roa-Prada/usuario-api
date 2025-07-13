package com.manuel.usuario_api.model;

// Importamos las anotaciones necesarias para JPA
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity // Marca esta clase como una entidad JPA (una tabla)
public class Usuario {
    @Id // Define el campo 'id' como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automáticamente
    
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo valido")
    private String correo;
    private LocalDate fechaRegistro; // Guardaremos la fecha de creación

    // Constructor vacío requerido por JPA
    public Usuario() {
        this.fechaRegistro = LocalDate.now(); // Asigna la fecha actual por defecto
    }

    // Constructor opcional para facilitar pruebas o creación directa
    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.fechaRegistro = LocalDate.now();
    }

    // Getters y setters obligatorios para acceder a los atributos

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
}
