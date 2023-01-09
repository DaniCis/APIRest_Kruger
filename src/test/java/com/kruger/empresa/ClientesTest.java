package com.kruger.empresa;

import com.kruger.empresa.model.Cliente;
import com.kruger.empresa.repository.ClienteRepository;
import com.kruger.empresa.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientesTest {

    @Mock
    private ClienteRepository repository;
    @InjectMocks
    private ClienteService service;

    private Cliente cliente;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        cliente = new Cliente();
        cliente.setNombre("Daniela");
        cliente.setCorreo("danicis@gmail.com");
        cliente.setCelular("09992983");
        cliente.setTipoIdent("CI");
        cliente.setNumeroIdent("171743192");
        cliente.setProvinciaMatriz("Pichincha");
        cliente.setCiudadMatriz("Quito");
        cliente.setDireccionMatriz("Conocoto");
    }
    @Test
    public void test_findAllClientes(){
        when(repository.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(service.findAll());
    }

    @Test
    public void test_saveCliente(){
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        assertNotNull(service.save(new Cliente()));
    }

    @Test
    public void test_findById(){
        when(repository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        assertNotNull(service.findById(1));
    }

    @Test
    public void test_findByName(){
        when(repository.findByNombre("Daniela")).thenReturn(Optional.ofNullable(cliente));
        assertNotNull(service.findByName("Daniela"));
    }
    @Test
    public void test_findByNum(){
        when(repository.findByNumeroIdent("1717431942")).thenReturn(Optional.ofNullable(cliente));
        assertNotNull(service.findByNumeroIdent("1717431942"));
    }
}
