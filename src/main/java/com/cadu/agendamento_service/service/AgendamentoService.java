package com.cadu.agendamento_service.service;

import com.cadu.agendamento_service.dto.AgendamentoDTO;
import com.cadu.agendamento_service.model.Agendamento;
import com.cadu.agendamento_service.model.Cliente;
import com.cadu.agendamento_service.model.Servico;
import com.cadu.agendamento_service.repository.AgendamentoRepository;
import com.cadu.agendamento_service.repository.ClienteRepository;
import com.cadu.agendamento_service.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository,
                              ClienteRepository clienteRepository,
                              ServicoRepository servicoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
    }

    public Agendamento agendar(AgendamentoDTO dto) {
        if (dto.getDataHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar para uma data ou hora no passado!");
        }

        if (agendamentoRepository.existsByDataHora(dto.getDataHora())) {
            throw new IllegalArgumentException("Já existe um agendamento para este horário!");
        }

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + dto.getClienteId()));

        Servico servico = servicoRepository.findById(dto.getServicoId())
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com id: " + dto.getServicoId()));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataHora(dto.getDataHora());
        agendamento.setStatus("AGENDADO");

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento cancelar(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado com id: " + id));

        agendamento.setStatus("CANCELADO");
        return agendamentoRepository.save(agendamento);
    }
}