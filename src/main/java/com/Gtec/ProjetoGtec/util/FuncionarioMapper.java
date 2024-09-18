package com.Gtec.ProjetoGtec.util;

import com.Gtec.ProjetoGtec.dto.request.FuncionarioRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.FuncionarioResponseDTO;
import com.Gtec.ProjetoGtec.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class FuncionarioMapper {
    public Funcionario toFuncionario(FuncionarioRequestDTO funcionarioDTO) {

        return Funcionario.builder()

                .nome(funcionarioDTO.getNome())
                .documento(funcionarioDTO.getDocumento())
                .telefone(funcionarioDTO.getTelefone())
                .email(funcionarioDTO.getEmail())
                .matricula(funcionarioDTO.getMatricula())

                .build();

    }

    public FuncionarioResponseDTO toFuncionarioDTO(Funcionario funcionario) {
        return new FuncionarioResponseDTO(funcionario);
    }

    public List<FuncionarioResponseDTO> toFuncionariosDTO(List<Funcionario> funcionariosList) {
        return funcionariosList.stream().map(FuncionarioResponseDTO::new).collect(Collectors.toList());
    }

    public void updateFuncionarioData(Funcionario funcionario, FuncionarioRequestDTO funcionarioDTO) {

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setDocumento(funcionarioDTO.getDocumento());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setMatricula(funcionarioDTO.getMatricula());

    }
}
