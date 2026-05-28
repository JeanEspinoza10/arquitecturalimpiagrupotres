package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * JPA ENTITY - representa la tabla 'vehiculos' en BD
 */
@Entity
@Table(name = "vehiculos")
@Getter
@Setter
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    @Column(unique = true, nullable = false)
    private String placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String estado;
}
