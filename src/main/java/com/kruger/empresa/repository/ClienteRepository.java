package com.kruger.empresa.repository;

import com.kruger.empresa.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findByNombre(String nombre);

    Optional<Cliente> findByNumeroIdent(String numeroIdent);

}
