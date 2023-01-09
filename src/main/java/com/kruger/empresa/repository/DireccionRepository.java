package com.kruger.empresa.repository;

import com.kruger.empresa.model.Direccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DireccionRepository  extends CrudRepository<Direccion, Integer> {
    Iterable<Direccion> findByClienteId(Integer id);
}
