package com.kruger.empresa.controller;

import com.kruger.empresa.model.Direccion;
import com.kruger.empresa.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService service;

    @RequestMapping(method= RequestMethod.GET, produces = "application/json" )
    public Iterable<Direccion> findAll(){
        return service.findAll();
    }
    @RequestMapping(value = "/save", method= RequestMethod.POST, produces ="application/json" )
    public ResponseEntity<?> save(@RequestBody Direccion entity){
        return ResponseEntity.ok(service.save(entity));
    }

    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT, produces = "application/json"  )
    public Direccion edit(@PathVariable Integer id, @RequestBody Direccion entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE, produces = "application/json"  )
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @RequestMapping(value = "/findId/{id}", method=RequestMethod.GET, produces = "application/json"  )
    public Optional<Direccion> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/listCliente/{id}", method = RequestMethod.GET, produces ="application/json")
    public Optional<Direccion> findByCliente(@PathVariable Integer id){
        return service.findByClienteId(id);
    }
}
