package com.VetTurno.VetTurno.controller;

import com.VetTurno.VetTurno.dto.PropietarioDTO;
import com.VetTurno.VetTurno.dto.PropietarioRequest;
import com.VetTurno.VetTurno.service.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {
    private final PropietarioService propietarioService;
    public PropietarioController(PropietarioService propietarioService){
        this.propietarioService = propietarioService;
    }

    @GetMapping
    public ResponseEntity<List<PropietarioDTO>> obtenerPropietarios(){
        return ResponseEntity.ok(propietarioService.listarPropietarios());
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> crear(@Valid @RequestBody PropietarioRequest request) {
        PropietarioDTO creado = propietarioService.crearPropietario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
