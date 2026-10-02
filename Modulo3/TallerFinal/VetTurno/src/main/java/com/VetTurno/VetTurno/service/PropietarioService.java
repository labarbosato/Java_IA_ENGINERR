package com.VetTurno.VetTurno.service;

import com.VetTurno.VetTurno.dto.PropietarioDTO;
import com.VetTurno.VetTurno.dto.PropietarioRequest;
import com.VetTurno.VetTurno.model.Propietario;
import com.VetTurno.VetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public PropietarioDTO crearPropietario(PropietarioRequest request){
        Propietario propietario = new Propietario();
        propietario.setNombre(request.getNombre());
        propietario.setTelefono(request.getTelefono());
        propietario.setEmail(request.getEmail());

        Propietario guardado = propietarioRepository.save(propietario);

        return new PropietarioDTO(guardado);
    }

    public List<PropietarioDTO> listarPropietarios(){
        List<Propietario> propietarios = propietarioRepository.findAll();
        List<PropietarioDTO> dtos = new ArrayList<>();

        for (Propietario p : propietarios) {
            dtos.add(new PropietarioDTO(p));
        }

        return dtos;
    }

}