package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.adapter;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository.VehiculoRepository;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.entity.VehiculoEntity;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.mapper.VehiculoMapper;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.repository.JpaVehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ADAPTER: Implementa VehiculoRepository usando JPA
 * Conecta el dominio (puerto) con la infraestructura de persistencia (adaptador)
 */
@Component
@RequiredArgsConstructor
public class VehiculoRepositoryAdapter implements VehiculoRepository {

    private final JpaVehiculoRepository jpaRepository;
    private final VehiculoMapper mapper;

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        VehiculoEntity entity = mapper.toEntity(vehiculo);
        VehiculoEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Vehiculo> findByPlaca(String placa) {
        return jpaRepository.findByPlaca(placa)
                .map(mapper::toDomain);
    }
}
