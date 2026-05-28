package com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.exception.VehiculoNotFoundException;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Estado;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;

/**
 * USE CASE: Registro de estado devuelto de un vehiculo
 * Permite actualizar el estado (LLENO, PARCIAL, VACIO) cuando el vehiculo es devuelto
 */
@RequiredArgsConstructor
public class ActualizarEstadoVehiculo {

    private final VehiculoRepository vehiculoRepository;

    public Vehiculo execute(String placa, String nuevoEstado) {
        Vehiculo vehiculo = vehiculoRepository
                .findByPlaca(placa)
                .orElseThrow(() -> new VehiculoNotFoundException(
                        "Vehiculo no encontrado con placa: " + placa
                ));

        try {
            vehiculo.setEstado(Estado.valueOf(nuevoEstado.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Estado invalido: '" + nuevoEstado + "'. Valores permitidos: LLENO, PARCIAL, VACIO"
            );
        }

        return vehiculoRepository.save(vehiculo);
    }
}
