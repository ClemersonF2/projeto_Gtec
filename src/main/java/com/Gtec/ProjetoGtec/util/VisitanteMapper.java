package com.Gtec.ProjetoGtec.util;

import com.Gtec.ProjetoGtec.dto.request.VisitanteRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.VisitanteResponseDTO;
import com.Gtec.ProjetoGtec.entity.Visitante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VisitanteMapper {

    public Visitante toVisitante(VisitanteRequestDTO visitanteDTO) {

        return Visitante.builder()

                .nome(visitanteDTO.getNome())
                .documento(visitanteDTO.getDocumento())
                .telefone(visitanteDTO.getTelefone())
                .email(visitanteDTO.getEmail())
                .renda_mensal(visitanteDTO.getRenda_mensal())

                .build();

    }

    public VisitanteResponseDTO toVisitanteDTO(Visitante visitante) {
        return new VisitanteResponseDTO(visitante);
    }

    public List<VisitanteResponseDTO> toVisitantesDTO(List<Visitante> visitantesList) {
        return visitantesList.stream().map(VisitanteResponseDTO::new).collect(Collectors.toList());
    }

    public void updateVisitanteData(Visitante visitante, VisitanteRequestDTO visitanteDTO) {

        visitante.setNome(visitanteDTO.getNome());
        visitante.setDocumento(visitanteDTO.getDocumento());
        visitante.setTelefone(visitanteDTO.getTelefone());
        visitante.setEmail(visitanteDTO.getEmail());
        visitante.setRenda_mensal(visitanteDTO.getRenda_mensal());

    }
}
