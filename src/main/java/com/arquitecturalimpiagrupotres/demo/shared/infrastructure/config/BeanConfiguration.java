package com.arquitecturalimpiagrupotres.demo.shared.infrastructure.config;

import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.ActualizarEstadoVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.RegistrarVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.VerificarEstadoVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.repository.VehiculoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CONFIGURACION DE BEANS
 * Registra los Use Cases como beans de Spring.
 * Los Use Cases NO tienen @Service para no acoplar el dominio a Spring.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public RegistrarVehiculo registrarVehiculo(VehiculoRepository vehiculoRepository) {
        return new RegistrarVehiculo(vehiculoRepository);
    }

    @Bean
    public VerificarEstadoVehiculo verificarEstadoVehiculo(VehiculoRepository vehiculoRepository) {
        return new VerificarEstadoVehiculo(vehiculoRepository);
    }

    @Bean
    public ActualizarEstadoVehiculo actualizarEstadoVehiculo(VehiculoRepository vehiculoRepository) {
        return new ActualizarEstadoVehiculo(vehiculoRepository);
    }
}
