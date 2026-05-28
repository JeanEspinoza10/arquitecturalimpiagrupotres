package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.controller;

import com.arquitecturalimpiagrupotres.demo.vehiculos.application.dto.RegistrarVehiculoCommand;
import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.ActualizarEstadoVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.RegistrarVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.application.usecase.VerificarEstadoVehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.domain.model.Vehiculo;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.RegistrarVehiculoRequest;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.VehiculoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST CONTROLLER
 * Expone las 4 funcionalidades de vehiculos via HTTP
 *
 * @RequiredArgsConstructor genera el constructor para inyeccion de dependencias
 */
@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final RegistrarVehiculo registrarVehiculo;
    private final VerificarEstadoVehiculo verificarEstadoVehiculo;
    private final ActualizarEstadoVehiculo actualizarEstadoVehiculo;

    /**
     * 1. Registro de vehiculo (con categoria hardcodeada desde enum)
     * POST /api/vehiculos
     */
    @PostMapping
    public ResponseEntity<Long> registrar(@RequestBody RegistrarVehiculoRequest request) {
        RegistrarVehiculoCommand command = new RegistrarVehiculoCommand();
        command.setPlaca(request.getPlaca());
        command.setMarca(request.getMarca());
        command.setModelo(request.getModelo());
        command.setCategoria(request.getCategoria());

        Long id = registrarVehiculo.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    /**
     * 2. Verificar estado del vehiculo por placa
     * GET /api/vehiculos/{placa}
     */
    @GetMapping("/{placa}")
    public ResponseEntity<VehiculoResponse> verificarEstado(@PathVariable String placa) {
        Vehiculo vehiculo = verificarEstadoVehiculo.execute(placa);
        return ResponseEntity.ok(VehiculoResponse.from(vehiculo));
    }

    /**
     * 3. Registro de estado devuelto del vehiculo
     * PATCH /api/vehiculos/{placa}/estado?estado=VACIO
     */
    @PatchMapping("/{placa}/estado")
    public ResponseEntity<VehiculoResponse> actualizarEstado(
            @PathVariable String placa,
            @RequestParam String estado) {
        Vehiculo vehiculo = actualizarEstadoVehiculo.execute(placa, estado);
        return ResponseEntity.ok(VehiculoResponse.from(vehiculo));
    }
}
