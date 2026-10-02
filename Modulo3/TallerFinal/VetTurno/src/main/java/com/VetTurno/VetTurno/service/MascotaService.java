package com.VetTurno.VetTurno.service;

import com.VetTurno.VetTurno.dto.MascotaDTO;
import com.VetTurno.VetTurno.dto.MascotaRequest;
import com.VetTurno.VetTurno.dto.PropietarioRequest;
import com.VetTurno.VetTurno.model.Mascota;
import com.VetTurno.VetTurno.model.Propietario;
import com.VetTurno.VetTurno.repository.MascotaRepository;
import com.VetTurno.VetTurno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService {
    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService (MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository){
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public MascotaDTO crearMascota(MascotaRequest request){
        Propietario propietario = propietarioRepository.findById(request.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException("El propietario no fue encontrado con el ID: " + request.getPropietarioId()));

        Mascota mascota = new Mascota();
        mascota.setNombre(request.getNombre());
        mascota.setEspecie(request.getEspecie());
        mascota.setRaza(request.getRaza());
        mascota.setPropietario(propietario);

        Mascota guardado = mascotaRepository.save(mascota);

        return new MascotaDTO(guardado);
    }

    public List<MascotaDTO> listarMascotas(){
        List<Mascota> mascotas = mascotaRepository.findAll();
        List<MascotaDTO> dtos = new ArrayList<>();

        for (Mascota m : mascotas){
            dtos.add(new MascotaDTO(m));
        }
        return dtos;
    }
}
