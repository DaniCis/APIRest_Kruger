package com.kruger.empresa.controller;

import com.kruger.empresa.model.Cliente;
import com.kruger.empresa.model.ErrorResponse;
import com.kruger.empresa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(method= RequestMethod.GET, produces = "application/json" )
    public Iterable<Cliente> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST, produces ="application/json" )
    public ResponseEntity<?> save(@RequestBody Cliente entity){
        Optional<Cliente> existe = service.findByNumeroIdent(entity.getNumeroIdent());
        if(existe.isPresent())
            return conflict();
        return ResponseEntity.ok(service.save(entity));
    }

    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT, produces = "application/json"  )
    public Cliente edit(@PathVariable Integer id, @RequestBody Cliente entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE, produces = "application/json"  )
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "Cliente elimnado con exito";
    }

    @RequestMapping(value = "/findId/{id}", method=RequestMethod.GET, produces = "application/json"  )
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Cliente> op =service.findById(id);
        if(!op.isPresent())
            return notFound();
        return ResponseEntity.ok(service.findById(id));
    }

    @RequestMapping(value = "/findName/{name}", method=RequestMethod.GET, produces = "application/json"  )
    public ResponseEntity<?> findByName(@PathVariable String name){
        Optional<Cliente> op = service.findByName(name);
        if(!op.isPresent())
            return notFound();
        return ResponseEntity.ok(service.findByName(name));
    }

    @RequestMapping(value = "/findNum/{num}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findByNum(@PathVariable String num){
        Optional<Cliente> op = service.findByNumeroIdent(num);
        if(!op.isPresent())
            return notFound();
        return ResponseEntity.ok(service.findByNumeroIdent(num));
    }

    private ResponseEntity<?> conflict(){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.toString(),"Ya existe un cliente registrado con esa identificacion"),
                HttpStatus.CONFLICT);
    }

    private ResponseEntity<?> notFound() {
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.NOT_FOUND.toString(), "Cliente no encontrado"),
                HttpStatus.NOT_FOUND);
    }
}
