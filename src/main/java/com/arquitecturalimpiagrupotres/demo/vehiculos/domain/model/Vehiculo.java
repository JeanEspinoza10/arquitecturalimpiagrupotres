package com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehiculo {
    private Long idVehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private Categoria categoria;
    private Estado estado;

    public static Categoria fromString(String value) {
        try {
            return Categoria.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Categoría inválida: '" + value + "'. Valores permitidos: SUV, SEDAN, CAMIONETA"
            );
        }
    }

}
