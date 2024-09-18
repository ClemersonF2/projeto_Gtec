package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.FuncionarioRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.FuncionarioResponseDTO;

import java.util.List;

public interface FuncionarioService {

    FuncionarioResponseDTO findById(Long id);

    List<FuncionarioResponseDTO> findAll();

    FuncionarioResponseDTO register(FuncionarioRequestDTO funcionarioDTO);

    FuncionarioResponseDTO update(Long id, FuncionarioRequestDTO funcionarioDTO);

    String delete(Long id);
}
