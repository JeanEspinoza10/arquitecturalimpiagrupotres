package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de salida HTTP
 */
@Getter
@Setter
public class VehiculoResponse {

    private Long idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
    private String estado;

    /**
     * Factory method para crear desde Vehiculo (dominio)
     */
    public static VehiculoResponse from(Vehiculo vehiculo) {
        VehiculoResponse response = new VehiculoResponse();
        response.setIdVehiculo(vehiculo.getIdVehiculo());
        response.setPlaca(vehiculo.getPlaca());
        response.setMarca(vehiculo.getMarca());
        response.setModelo(vehiculo.getModelo());
        response.setCategoria(vehiculo.getCategoria().name());
        response.setEstado(vehiculo.getEstado().name());
        return response;
    }
}
