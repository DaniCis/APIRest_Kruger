package com.kruger.empresa.controller;

import com.kruger.empresa.model.Cliente;
import com.kruger.empresa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Cliente save(@RequestBody Cliente entity){
        return service.save(entity);
    }

    @RequestMapping(value = "/update/{id}", method=RequestMethod.PUT, produces = "application/json"  )
    public Cliente edit(@PathVariable Integer id, @RequestBody Cliente entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.DELETE, produces = "application/json"  )
    public void delete(@PathVariable Integer id) { service.deleteById(id); }

    @RequestMapping(value = "/findId/{id}", method=RequestMethod.GET, produces = "application/json"  )
    public Optional<Cliente> findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/findName/{name}", method=RequestMethod.GET, produces = "application/json"  )
    public Optional<Cliente> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
