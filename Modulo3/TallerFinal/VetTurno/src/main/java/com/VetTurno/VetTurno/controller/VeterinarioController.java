package com.VetTurno.VetTurno.controller;

import com.VetTurno.VetTurno.dto.VeterinarioDTO;
import com.VetTurno.VetTurno.dto.VeterinarioRequest;
import com.VetTurno.VetTurno.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {
    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService){
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> obtenerVeterinarios(){
        return ResponseEntity.ok(veterinarioService.listarVeterinarios());
    }

    @PostMapping
    public ResponseEntity<VeterinarioDTO> crear(@Valid @RequestBody VeterinarioRequest request) {
        VeterinarioDTO creado = veterinarioService.crearVeterinario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
