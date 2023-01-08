package com.kruger.empresa.service;

import com.kruger.empresa.model.Cliente;
import com.kruger.empresa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Iterable<Cliente> findAll(){
        return repository.findAll();
    }

    public Optional<Cliente> findById(Integer id){
        return repository.findById(id);
    }

    public Cliente save(Cliente entity){
        return repository.save(entity);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Optional<Cliente> findByName(String name){
        return repository.findByNombre(name);
    }

}
