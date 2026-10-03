package com.VetTurno.VetTurno.controller;

import com.VetTurno.VetTurno.dto.CitaDTO;
import com.VetTurno.VetTurno.dto.CitaRequest;
import com.VetTurno.VetTurno.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    private final CitaService citaService;
    public CitaController(CitaService citaService){
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> obtenerCitas(){
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crear(@Valid @RequestBody CitaRequest request){
        CitaDTO creado = citaService.crearCita(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/veterinario/{id}")
    public ResponseEntity<List<CitaDTO>> obtenerPorVeterinario(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.listarPorVeterinario(id));
    }
}
