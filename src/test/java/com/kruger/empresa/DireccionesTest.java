package com.kruger.empresa;

import com.kruger.empresa.model.Cliente;
import com.kruger.empresa.model.Direccion;
import com.kruger.empresa.repository.DireccionRepository;
import com.kruger.empresa.service.DireccionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DireccionesTest {
    @Mock
    private DireccionRepository repository;
    @InjectMocks
    private DireccionService service;

    private Direccion direccion;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
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

        direccion = new Direccion();
        direccion.setDireccion("Conocoto");
        direccion.setCiudad("Quito");
        direccion.setProvincia("Pichincha");
        direccion.setClienteId(1);
    }

    @Test
    public void test_findAllDirecciones(){
        when(repository.findAll()).thenReturn(Arrays.asList(direccion));
        assertNotNull(service.findAll());
    }

    @Test
    public void test_saveDireccion(){
        when(repository.save(any(Direccion.class))).thenReturn(direccion);
        assertNotNull(service.save(new Direccion()));
    }

}
