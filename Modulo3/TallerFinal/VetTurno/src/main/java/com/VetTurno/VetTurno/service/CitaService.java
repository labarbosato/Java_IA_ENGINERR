package com.VetTurno.VetTurno.service;

import com.VetTurno.VetTurno.dto.CitaDTO;
import com.VetTurno.VetTurno.dto.CitaRequest;
import com.VetTurno.VetTurno.model.Cita;
import com.VetTurno.VetTurno.model.Mascota;
import com.VetTurno.VetTurno.model.Veterinario;
import com.VetTurno.VetTurno.repository.CitaRepository;
import com.VetTurno.VetTurno.repository.MascotaRepository;
import com.VetTurno.VetTurno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaService (CitaRepository citaRepository, MascotaRepository mascotaRepository, VeterinarioRepository veterinarioRepository){
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public CitaDTO crearCita (CitaRequest request){
        Mascota mascota = mascotaRepository.findById(request.getMascotaId())
                .orElseThrow(()-> new IllegalArgumentException("La mascota no fue encontrado con el ID: " + request.getMascotaId()));
        Veterinario veterinario = veterinarioRepository.findById(request.getVeterinarioId())
                .orElseThrow(()-> new IllegalArgumentException("El Veterinario no fue encontrado con el ID: " + request.getVeterinarioId()));

        Cita cita = new Cita();
        cita.setFechaHora(request.getFechaHora());
        cita.setMotivo(request.getMotivo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        Cita guardado = citaRepository.save(cita);

        return new CitaDTO(guardado);
    }

    public List<CitaDTO> listarCitas(){
        List<Cita> citas = citaRepository.findAll();
        List<CitaDTO> dtos = new ArrayList<>();

        for (Cita c : citas){
            dtos.add(new CitaDTO(c));
        }
        return dtos;
    }
}
