package com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase;

import com.arquitecturalimpiagrupotres.demo.vehiculos.application.dto.RegistrarVehiculoCommand;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Estado;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;

public class RegistrarVehiculo {
    public Vehiculo execute(RegistrarVehiculoCommand registrarVehiculoCommand){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(registrarVehiculoCommand.getPlaca());
        vehiculo.setMarca(registrarVehiculoCommand.getMarca());
        vehiculo.setModelo(registrarVehiculoCommand.getModelo());
        vehiculo.setCategoria(Vehiculo.fromString(registrarVehiculoCommand.getCategoria()));
        vehiculo.setEstado(Estado.LLENO);
        return vehiculo;
    }
}
/*
* Registro de vehiculos
* Registro de categoria de vehiculos - hardcodeado
* Verificar estado del vehiculo
* Registro de estado de vehiculo devuelto
*
* */