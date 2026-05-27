package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegistrarVehiculoRequest {
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
}
