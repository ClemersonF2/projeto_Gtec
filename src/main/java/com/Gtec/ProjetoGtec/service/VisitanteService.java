package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.VisitanteRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.VisitanteResponseDTO;

import java.util.List;

public interface VisitanteService {

    VisitanteResponseDTO findById(Long id);

    List<VisitanteResponseDTO> findAll();

    VisitanteResponseDTO register(VisitanteRequestDTO visitanteDTO);

    VisitanteResponseDTO update(Long id, VisitanteRequestDTO visitanteDTO);

    String delete(Long id);
    
    
}
