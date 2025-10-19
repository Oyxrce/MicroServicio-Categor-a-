package com.example.categoria_service.service;

import com.example.categoria_service.model.Categoria;
import com.example.categoria_service.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    
    private final CategoriaRepository repository;
    
    @Override
    @Transactional
    public Categoria crear(Categoria categoria) {
        if (repository.existsByNombre(categoria.getNombre())) {
            throw new RuntimeException("Categoría ya existe");
        }
        return repository.save(categoria);
    }
    
    @Override
    public List<Categoria> obtenerTodos() {
        return repository.findAll();
    }
    
    @Override
    public Categoria obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }
    
    @Override
    @Transactional
    public Categoria actualizar(Long id, Categoria categoria) {
        Categoria existe = obtenerPorId(id);
        existe.setNombre(categoria.getNombre());
        return repository.save(existe);
    }
    
    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}