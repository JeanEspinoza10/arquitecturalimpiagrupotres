package com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase;

import com.arquitecturalimpiagrupotres.demo.vehiculos.application.dto.RegistrarVehiculoCommand;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Estado;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;

/**
 * USE CASE: Registro de vehículos
 * - La categoría se asigna desde el enum Categoria (hardcodeado)
 * - El estado inicial siempre es LLENO al registrar
 *
 * @RequiredArgsConstructor genera el constructor para inyección de dependencias
 */
@RequiredArgsConstructor
public class RegistrarVehiculo {

    private final VehiculoRepository vehiculoRepository;

    public Long execute(RegistrarVehiculoCommand command) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(command.getPlaca());
        vehiculo.setMarca(command.getMarca());
        vehiculo.setModelo(command.getModelo());
        // Registro de categoría hardcodeado desde el enum Categoria
        vehiculo.setCategoria(Vehiculo.fromString(command.getCategoria()));
        // Estado inicial al registrar
        vehiculo.setEstado(Estado.LLENO);

        Vehiculo guardado = vehiculoRepository.save(vehiculo);
        return guardado.getIdVehiculo();
    }
}

/*
* Registro de vehiculos
* Registro de categoria de vehiculos - hardcodeado
* Verificar estado del vehiculo
* Registro de estado de vehiculo devuelto
*
* */