package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de entrada HTTP para registrar vehiculo
 */
@Getter
@Setter
public class RegistrarVehiculoRequest {

    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
}
