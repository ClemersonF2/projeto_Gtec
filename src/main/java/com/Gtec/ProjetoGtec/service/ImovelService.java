package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.ImovelRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.entity.Imovel;

import java.util.List;


public interface ImovelService {

    ImovelResponseDTO findById(Long id);

    List<ImovelResponseDTO> findAll();

    ImovelResponseDTO register(ImovelRequestDTO imovelDTO);

    ImovelResponseDTO update(Long id, ImovelRequestDTO imovelDTO);

    String delete(Long id);
}
