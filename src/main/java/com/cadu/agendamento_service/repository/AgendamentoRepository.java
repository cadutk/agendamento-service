package com.cadu.agendamento_service.repository;

import com.cadu.agendamento_service.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByDataHora(LocalDateTime dataHora);

    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}