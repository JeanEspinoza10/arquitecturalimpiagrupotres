package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ActualizarEstadoResponse {
    private String placa;
    private String estadoAnterior;
    private String estadoActual;
}


