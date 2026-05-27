package com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.controller;

import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.ActualizarEstadoRequest;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.ActualizarEstadoResponse;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.ConsultarEstadoResponse;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.RegistrarVehiculoRequest;
import com.arquitecturalimpiagrupotres.demo.vehiculos.infrastructure.web.dto.RegistrarVehiculoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @PostMapping
    public ResponseEntity<RegistrarVehiculoResponse> registrarVehiculo(@RequestBody RegistrarVehiculoRequest request) {

        RegistrarVehiculoResponse response = new RegistrarVehiculoResponse(1L,"ABC-123","Toyota",
                "RAV4","CAMIONETA","LLENO");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{placa}/estado")
    public ResponseEntity<ConsultarEstadoResponse> consultarEstado(@PathVariable String placa) {

        ConsultarEstadoResponse response = new ConsultarEstadoResponse(placa, "PARCIAL");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{placa}/estado")
    public ResponseEntity<ActualizarEstadoResponse> actualizarEstado(@PathVariable String placa,
                                                                     @RequestBody ActualizarEstadoRequest request) {

        ActualizarEstadoResponse response = new ActualizarEstadoResponse(placa, "LLENO", "VACIO");
        return ResponseEntity.ok(response);

    }
}
