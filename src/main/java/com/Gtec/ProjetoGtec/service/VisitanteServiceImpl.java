package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.VisitanteRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.VisitanteResponseDTO;
import com.Gtec.ProjetoGtec.entity.Visitante;
import com.Gtec.ProjetoGtec.repository.VisitanteRepository;
import com.Gtec.ProjetoGtec.util.VisitanteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class VisitanteServiceImpl implements VisitanteService {

    private final VisitanteRepository visitanteRepository;

    private final VisitanteMapper visitanteMapper;


    @Override
    public VisitanteResponseDTO findById(Long id) {
        return visitanteMapper.toVisitanteDTO(returnVisitante(id));
    }

    @Override
    public List<VisitanteResponseDTO> findAll() {
        return visitanteMapper.toVisitantesDTO(visitanteRepository.findAll());
    }

    @Override
    public VisitanteResponseDTO register(VisitanteRequestDTO visitanteDTO) {

        Visitante visitante = visitanteMapper.toVisitante(visitanteDTO);

        return visitanteMapper.toVisitanteDTO(visitanteRepository.save(visitante));
    }

    @Override
    public VisitanteResponseDTO update(Long id, VisitanteRequestDTO visitanteDTO) {

        Visitante visitante = returnVisitante(id);

        visitanteMapper.updateVisitanteData(visitante,visitanteDTO);

        return visitanteMapper.toVisitanteDTO(visitanteRepository.save(visitante));
    }

    @Override
    public String delete(Long id) {
        visitanteRepository.deleteById(id);
        return "Visitante id: "+id+" deleted";
    }

    private Visitante returnVisitante(Long id) {
        return visitanteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Visitante não foi encontrado no banco de dados"));
    }
    
}
