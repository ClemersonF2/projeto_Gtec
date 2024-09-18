package com.Gtec.ProjetoGtec.util;

import com.Gtec.ProjetoGtec.dto.request.ImovelRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.entity.Imovel;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ImovelMapper {
    public Imovel toImovel(ImovelRequestDTO imovelDTO) {

        return Imovel.builder()
                .dormitorios(imovelDTO.getDormitorios())
                .valorAluguel(imovelDTO.getValorAluguel())
                .valorCondominio(imovelDTO.getValorCondominio())
                .valorIptu(imovelDTO.getValorIptu())
                .valorTaxaIncendio(imovelDTO.getValorTaxaIncendio())
                .cep(imovelDTO.getCep())
                .logradouro(imovelDTO.getLogradouro())
                .bairro(imovelDTO.getBairro())
                .complemento(imovelDTO.getComplemento())

                .build();

    }

    public ImovelResponseDTO toImovelDTO(Imovel imovel) {
        return new ImovelResponseDTO(imovel);
    }

    public Imovel toImovel(Imovel imovel) {
        return new Imovel(imovel);
    }

    public List<ImovelResponseDTO> toImovelsDTO(List<Imovel> imovelsList) {
        return imovelsList.stream().map(ImovelResponseDTO::new).collect(Collectors.toList());
    }

    public void updateImovelData(Imovel imovel, ImovelRequestDTO imovelDTO) {

        imovel.setDormitorios(imovelDTO.getDormitorios());
        imovel.setValorAluguel(imovelDTO.getValorAluguel());
        imovel.setValorCondominio(imovelDTO.getValorCondominio());
        imovel.setValorIptu(imovelDTO.getValorIptu());
        imovel.setValorTaxaIncendio(imovelDTO.getValorTaxaIncendio());
        imovel.setCep(imovelDTO.getCep());
        imovel.setLogradouro(imovelDTO.getLogradouro());
        imovel.setBairro(imovelDTO.getBairro());
        imovel.setComplemento(imovelDTO.getComplemento());


    }
}
