package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.AgendamentoRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.AgendamentoResponseDTO;
import com.Gtec.ProjetoGtec.entity.Agendamento;
import com.Gtec.ProjetoGtec.repository.AgendamentoRepository;
import com.Gtec.ProjetoGtec.util.AgendamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final AgendamentoMapper agendamentoMapper;


    @Override
    public AgendamentoResponseDTO findById(Long id) {
        return agendamentoMapper.toAgendamentoDTO(returnAgendamento(id));
    }

    @Override
    public List<AgendamentoResponseDTO> findAll() {
        return agendamentoMapper.toAgendamentoDTO(agendamentoRepository.findAll());
    }

    @Override
    public AgendamentoResponseDTO register(AgendamentoRequestDTO agendamentoDTO) {

        Agendamento agendamento = agendamentoMapper.toAgendamento(agendamentoDTO);

        return agendamentoMapper.toAgendamentoDTO(agendamentoRepository.save(agendamento));
    }

    @Override
    public AgendamentoResponseDTO update(Long id, AgendamentoRequestDTO agendamentoDTO) {

        Agendamento agendamento = returnAgendamento(id);

        agendamentoMapper.updateAgendamentoData(agendamento,agendamentoDTO);

        return agendamentoMapper.toAgendamentoDTO(agendamentoRepository.save(agendamento));
    }

    @Override
    public String delete(Long id) {
       agendamentoRepository.deleteById(id);
        return "Agendamento id: "+id+" deleted";
    }

    private Agendamento returnAgendamento(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Agendamento não foi encontrado no banco de dados"));
    }
    
    
    
}
