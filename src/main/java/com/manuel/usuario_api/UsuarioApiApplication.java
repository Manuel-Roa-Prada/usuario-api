package com.manuel.usuario_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jakarta.validation.Validator;

@SpringBootApplication
public class UsuarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApiApplication.class, args);
	}
    
	@Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
   

   
}
