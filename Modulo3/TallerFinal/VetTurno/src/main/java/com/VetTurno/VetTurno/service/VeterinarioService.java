package com.VetTurno.VetTurno.service;

import com.VetTurno.VetTurno.dto.VeterinarioDTO;
import com.VetTurno.VetTurno.dto.VeterinarioRequest;
import com.VetTurno.VetTurno.model.Veterinario;
import com.VetTurno.VetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeterinarioService {
    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository){
        this.veterinarioRepository = veterinarioRepository;
    }

    public VeterinarioDTO crearVeterinario(VeterinarioRequest request){
        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(request.getNombre());
        veterinario.setEspecialidad(request.getEspecialidad());

        Veterinario guardado = veterinarioRepository.save(veterinario);

        return new VeterinarioDTO(guardado);
    }

    public List<VeterinarioDTO> listarVeterinarios(){
        List<Veterinario> veterinarios = veterinarioRepository.findAll();
        List<VeterinarioDTO> dtos = new ArrayList<>();

        for (Veterinario v : veterinarios){
            dtos.add(new VeterinarioDTO(v));
        }
        return dtos;
    }
}
