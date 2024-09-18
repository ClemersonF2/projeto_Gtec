package com.Gtec.ProjetoGtec.dto.response;

import com.Gtec.ProjetoGtec.entity.Funcionario;
import lombok.Getter;

@Getter
public class FuncionarioResponseDTO {


    private Long id;

    private String nome;

    private String documento;

    private String telefone;

    private String email;

    private String matricula;

    public FuncionarioResponseDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.documento = funcionario.getDocumento();
        this.telefone = funcionario.getTelefone();
        this.email = funcionario.getEmail();
        this.matricula = funcionario.getMatricula();
    }
}