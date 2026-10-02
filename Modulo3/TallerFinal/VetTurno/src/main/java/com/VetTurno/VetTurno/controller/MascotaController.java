package com.VetTurno.VetTurno.controller;

import com.VetTurno.VetTurno.dto.MascotaDTO;
import com.VetTurno.VetTurno.dto.MascotaRequest;
import com.VetTurno.VetTurno.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> obtenerMascotas(){
        return ResponseEntity.ok(mascotaService.listarMascotas());
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> crear(@Valid @RequestBody MascotaRequest request){
        MascotaDTO creado = mascotaService.crearMascota(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
