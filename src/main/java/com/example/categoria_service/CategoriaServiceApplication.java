package com.example.categoria_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CategoriaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoriaServiceApplication.class, args);
        System.out.println("\n MicroServicio Categoria Operativo - Puerto 8084\n");
    }
	}