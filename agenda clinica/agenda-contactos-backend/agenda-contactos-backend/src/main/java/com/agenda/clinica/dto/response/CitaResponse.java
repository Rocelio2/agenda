package com.agenda.clinica.dto.response;
import com.agenda.clinica.entity.Cita; import java.time.LocalDateTime;
public record CitaResponse(Long id,String paciente,String telefono,String medico,String especialidad,LocalDateTime inicio,LocalDateTime fin,String estado,String motivo) { public static CitaResponse from(Cita c){return new CitaResponse(c.getId(),c.getPaciente().getNombre(),c.getPaciente().getTelefono(),c.getMedico().getNombre(),c.getMedico().getEspecialidad().getNombre(),c.getInicio(),c.getFin(),c.getEstado(),c.getMotivo());} }
