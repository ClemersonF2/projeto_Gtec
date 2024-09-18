package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.ImovelRequestDTO;
import com.Gtec.ProjetoGtec.dto.request.ImovelRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.entity.Imovel;
import com.Gtec.ProjetoGtec.repository.ImovelRepository;
import com.Gtec.ProjetoGtec.repository.ImovelRepository;
import com.Gtec.ProjetoGtec.util.ImovelMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;


@Primary
@Service
@RequiredArgsConstructor
public class ImovelServiceImpl implements ImovelService {

    private final ImovelRepository imovelRepository;

    private final ImovelMapper imovelMapper;


    @Override
    public ImovelResponseDTO findById(Long id) {
        return imovelMapper.toImovelDTO(returnImovel(id));
    }


    @Override
    public List<ImovelResponseDTO> findAll() {
        return imovelMapper.toImovelsDTO(imovelRepository.findAll());
    }

    @Override
    public ImovelResponseDTO register(ImovelRequestDTO imovelDTO) {

        Imovel imovel = imovelMapper.toImovel(imovelDTO);

        return imovelMapper.toImovelDTO(imovelRepository.save(imovel));
    }

    @Override
    public ImovelResponseDTO update(Long id, ImovelRequestDTO imovelDTO) {

        Imovel imovel = returnImovel(id);

      imovelMapper.updateImovelData(imovel,imovelDTO);

        return imovelMapper.toImovelDTO(imovelRepository.save(imovel));
    }

    @Override
    public String delete(Long id) {
        imovelRepository.deleteById(id);
        return "Imovel id: "+id+" deleted";
    }

    private Imovel returnImovel(Long id) {
        return imovelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Imovel não foi encontrado no banco de dados"));
    }
}
