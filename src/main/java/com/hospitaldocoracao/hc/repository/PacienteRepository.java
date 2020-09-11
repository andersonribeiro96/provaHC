package com.hospitaldocoracao.hc.repository;


import com.hospitaldocoracao.hc.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

  @Query(value = "SELECT * FROM PACIENTE WHERE ATENDIDO = false", nativeQuery = true)
  List<Paciente> listarPacienteNaoAtendidos();


}
