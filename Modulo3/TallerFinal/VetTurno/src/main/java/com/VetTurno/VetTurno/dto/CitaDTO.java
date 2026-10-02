package com.VetTurno.VetTurno.dto;

import com.VetTurno.VetTurno.model.Cita;

import java.time.LocalDateTime;

public class CitaDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private String mascotaNombre;
    private String propietarioNombre;
    private String veterinarioNombre;


    public CitaDTO(Cita cita){
        this.id = cita.getId();
        this.fechaHora = cita.getFechaHora();
        this.motivo = cita.getMotivo();
        this.mascotaNombre = cita.getMascota() != null ? cita.getMascota().getNombre() : null;
        this.propietarioNombre = (cita.getMascota() != null && cita.getMascota().getPropietario() != null)
                ? cita.getMascota().getPropietario().getNombre() : null;
        this.veterinarioNombre = cita.getVeterinario() != null ? cita.getVeterinario().getNombre() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

    public String getPropietarioNombre() {
        return propietarioNombre;
    }

    public void setPropietarioNombre(String propietarioNombre) {
        this.propietarioNombre = propietarioNombre;
    }

    public String getVeterinarioNombre() {
        return veterinarioNombre;
    }

    public void setVeterinarioNombre(String veterinarioNombre) {
        this.veterinarioNombre = veterinarioNombre;
    }
}
