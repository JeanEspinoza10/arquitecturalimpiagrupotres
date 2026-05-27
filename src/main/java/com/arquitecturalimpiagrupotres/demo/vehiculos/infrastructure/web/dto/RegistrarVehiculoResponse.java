package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrarVehiculoResponse {
    private Long idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
    private String estado;
}

