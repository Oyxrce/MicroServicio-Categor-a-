package com.example.categoria_service.service;

import com.example.categoria_service.model.Categoria;
import java.util.List;

public interface CategoriaService {
    Categoria crear(Categoria categoria);
    List<Categoria> obtenerTodos();
    Categoria obtenerPorId(Long id);
    Categoria actualizar(Long id, Categoria categoria);
    void eliminar(Long id);
}