package com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;

import java.util.Optional;

/**
 * REPOSITORY INTERFACE (puerto de dominio)
 * Define el contrato que debe cumplir la infraestructura.
 * El dominio no sabe nada de JPA ni de BD.
 */
public interface VehiculoRepository {

    Vehiculo save(Vehiculo vehiculo);

    Optional<Vehiculo> findById(Long id);

    Optional<Vehiculo> findByPlaca(String placa);
}
