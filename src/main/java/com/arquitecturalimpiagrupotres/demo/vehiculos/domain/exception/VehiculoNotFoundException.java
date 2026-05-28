package com.arquitecturalimpiagrupotres.demo.vehiculos.domain.exception;

/**
 * DOMAIN EXCEPTION: Se lanza cuando no se encuentra un vehículo
 */
public class VehiculoNotFoundException extends RuntimeException {

    public VehiculoNotFoundException(String message) {
        super(message);
    }
}

