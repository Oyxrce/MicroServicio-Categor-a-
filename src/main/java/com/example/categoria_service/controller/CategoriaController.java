package com.example.categoria_service.controller;

import com.example.categoria_service.model.Categoria;
import com.example.categoria_service.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoriaController {
    
    private final CategoriaService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria crear(@Valid @RequestBody Categoria categoria) {
        return service.crear(categoria);
    }
    
    @GetMapping
    public List<Categoria> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return service.actualizar(id, categoria);
    }
    
    @PatchMapping("/{id}")
    public Categoria actualizarParcial(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.actualizar(id, categoria);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}