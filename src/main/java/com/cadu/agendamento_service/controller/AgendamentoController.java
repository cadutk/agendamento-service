package com.cadu.agendamento_service.controller;

import com.cadu.agendamento_service.dto.AgendamentoDTO;
import com.cadu.agendamento_service.model.Agendamento;
import com.cadu.agendamento_service.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody AgendamentoDTO dto) {
        try {
            Agendamento novoAgendamento = agendamentoService.agendar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        try {
            Agendamento agendamentoCancelado = agendamentoService.cancelar(id);
            return ResponseEntity.ok(agendamentoCancelado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}