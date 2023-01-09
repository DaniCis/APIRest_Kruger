package com.kruger.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private String celular;
    @NotNull
    private String tipoIdent;
    @NotNull
    private String numeroIdent;
    @NotNull
    private String direccionMatriz;
    @NotNull
    private String ciudadMatriz;
    @NotNull
    private String provinciaMatriz;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId")
    private Set<Direccion> direcciones = new HashSet<Direccion>();
}
