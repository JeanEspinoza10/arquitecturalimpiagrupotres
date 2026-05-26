package com.arquitecturalimpiagrupotres.demo.vehiculos.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarVehiculoCommand {
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
}
