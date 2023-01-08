package com.kruger.empresa.service;

import com.kruger.empresa.model.Direccion;
import com.kruger.empresa.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository repository;
    public Iterable<Direccion> findAll(){
        return repository.findAll();
    }
    public Direccion save(Direccion entity){
        return repository.save(entity);
    }
}
