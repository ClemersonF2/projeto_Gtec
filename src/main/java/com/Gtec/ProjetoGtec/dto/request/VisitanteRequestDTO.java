package com.Gtec.ProjetoGtec.dto.request;

import lombok.Getter;

@Getter
public class VisitanteRequestDTO {

    private String nome;

    private String documento;

    private String telefone;

    private String email;

    private double renda_mensal;
}
