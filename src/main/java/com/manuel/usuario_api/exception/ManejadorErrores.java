package com.manuel.usuario_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
//  errores globales de la API REST
@RestControllerAdvice
public class ManejadorErrores {

    // se ejecuta automáticamente cuando una validación falla 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        
        // Creamos un mapa para guardar los errores campo -> mensaje
        Map<String, String> errores = new HashMap<>();

        // Recorremos todos los errores de validación capturados
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String campo = error.getField(); 
            String mensaje = error.getDefaultMessage(); 
            errores.put(campo, mensaje);
        });

        // Devolvemos el mapa como respuesta con un código HTTP 400 (Bad Request)
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // captura cualquier RuntimeException no controlada 
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        // Devolvemos el mensaje de error con un código HTTP 404 (o el que elijas)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
