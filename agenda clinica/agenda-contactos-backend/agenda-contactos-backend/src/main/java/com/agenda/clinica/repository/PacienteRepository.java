package com.agenda.clinica.repository;
import com.agenda.clinica.entity.Paciente; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import jakarta.persistence.LockModeType; import java.util.Optional;
public interface PacienteRepository extends JpaRepository<Paciente,Long> { Optional<Paciente> findByDocumento(String documento); Optional<Paciente> findByTelefono(String telefono); @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select p from Paciente p where p.id=:id") Optional<Paciente> bloquear(@Param("id") Long id); }
