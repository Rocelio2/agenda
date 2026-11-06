package com.agenda.clinica.dto.request;
import jakarta.validation.constraints.*; import java.time.LocalDateTime;
public record CitaRequest(@NotBlank String nombrePaciente,@NotBlank String telefono,@Email String correo,String documento,@NotNull Long medicoId,@NotNull LocalDateTime inicio,@NotNull LocalDateTime fin,@Size(max=500) String motivo) {}
