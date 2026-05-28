package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.repository;

import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA Repository
 */
@Repository
public interface JpaVehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    Optional<VehiculoEntity> findByPlaca(String placa);
}
