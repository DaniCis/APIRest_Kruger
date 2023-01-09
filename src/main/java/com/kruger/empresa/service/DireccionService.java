package com.kruger.empresa.service;

import com.kruger.empresa.model.Direccion;
import com.kruger.empresa.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository repository;
    public Iterable<Direccion> findAll(){
        return repository.findAll();
    }
    public Optional<Direccion> findById(Integer id){
        return repository.findById(id);
    }
    public Direccion save(Direccion entity){
        return repository.save(entity);
    }
    public Iterable<Direccion> findByClienteId(Integer id){
        return repository.findByClienteId(id);
    }
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
