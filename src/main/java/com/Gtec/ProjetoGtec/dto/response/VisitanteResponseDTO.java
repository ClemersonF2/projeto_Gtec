package com.Gtec.ProjetoGtec.dto.response;

import com.Gtec.ProjetoGtec.entity.Visitante;
import lombok.Getter;

@Getter
public class VisitanteResponseDTO {

    private Long id;

    private String nome;

    private String documento;

    private String telefone;

    private String email;

    private double renda_mensal;

    public VisitanteResponseDTO(Visitante visitante){
        this.id = visitante.getId();
        this.nome = visitante.getNome();
        this.documento = visitante.getDocumento();
        this.telefone = visitante.getTelefone();
        this.email = visitante.getEmail();
        this.renda_mensal = visitante.getRenda_mensal();
    }
}
