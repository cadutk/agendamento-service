package com.cadu.agendamento_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    private Long clienteId;
    private Long servicoId;
    private LocalDateTime dataHora;
}