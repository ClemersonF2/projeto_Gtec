package com.Gtec.ProjetoGtec.dto.response;

import com.Gtec.ProjetoGtec.entity.Imovel;
import lombok.Getter;

@Getter
public class ImovelResponseDTO {

    private  Long id;

    private int dormitorios;

    private double valorAluguel;

    private double valorCondominio;

    private double valorIptu;

    private double valorTaxaIncendio;

    private String cep;

    private String logradouro;

    private String bairro;

    private String complemento;


    public ImovelResponseDTO(Imovel imovel) {
        this.id = imovel.getId();
        this.dormitorios = imovel.getDormitorios();
        this.valorAluguel = imovel.getValorAluguel();
        this.valorCondominio = imovel.getValorCondominio();
        this.valorIptu = imovel.getValorIptu();
        this.valorTaxaIncendio = imovel.getValorTaxaIncendio();
        this.cep = imovel.getCep();
        this.logradouro = imovel.getLogradouro();
        this.bairro = imovel.getBairro();
        this.complemento = imovel.getComplemento();
    }
}
