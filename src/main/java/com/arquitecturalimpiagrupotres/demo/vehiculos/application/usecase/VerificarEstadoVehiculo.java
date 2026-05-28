package com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.exception.VehiculoNotFoundException;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;

/**
 * USE CASE: Verificar estado actual de un vehículo por su placa
 *
 * @RequiredArgsConstructor genera el constructor para inyección de dependencias
 */
@RequiredArgsConstructor
public class VerificarEstadoVehiculo {

    private final VehiculoRepository vehiculoRepository;

    public Vehiculo execute(String placa) {
        return vehiculoRepository
                .findByPlaca(placa)
                .orElseThrow(() -> new VehiculoNotFoundException(
                        "Vehículo no encontrado con placa: " + placa
                ));
    }
}

