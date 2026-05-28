package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.mapper;

import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Categoria;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Estado;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.persistence.entity.VehiculoEntity;
import org.springframework.stereotype.Component;

/**
 * MAPPER: Convierte entre Vehiculo (dominio) y VehiculoEntity (JPA)
 */
@Component
public class VehiculoMapper {

    public VehiculoEntity toEntity(Vehiculo vehiculo) {
        VehiculoEntity entity = new VehiculoEntity();
        entity.setIdVehiculo(vehiculo.getIdVehiculo());
        entity.setPlaca(vehiculo.getPlaca());
        entity.setMarca(vehiculo.getMarca());
        entity.setModelo(vehiculo.getModelo());
        entity.setCategoria(vehiculo.getCategoria().name());
        entity.setEstado(vehiculo.getEstado().name());
        return entity;
    }

    public Vehiculo toDomain(VehiculoEntity entity) {
        if (entity == null) return null;
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setIdVehiculo(entity.getIdVehiculo());
        vehiculo.setPlaca(entity.getPlaca());
        vehiculo.setMarca(entity.getMarca());
        vehiculo.setModelo(entity.getModelo());
        vehiculo.setCategoria(Categoria.valueOf(entity.getCategoria()));
        vehiculo.setEstado(Estado.valueOf(entity.getEstado()));
        return vehiculo;
    }
}
