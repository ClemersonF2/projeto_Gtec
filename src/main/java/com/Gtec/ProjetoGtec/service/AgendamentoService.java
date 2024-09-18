package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.AgendamentoRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.AgendamentoResponseDTO;

import java.util.List;

public interface AgendamentoService {


    AgendamentoResponseDTO findById(Long id);

    List<AgendamentoResponseDTO> findAll();

    AgendamentoResponseDTO register(AgendamentoRequestDTO agendamentoDTO);

    AgendamentoResponseDTO update(Long id, AgendamentoRequestDTO agendamentoDTO);

    String delete(Long id);
}
