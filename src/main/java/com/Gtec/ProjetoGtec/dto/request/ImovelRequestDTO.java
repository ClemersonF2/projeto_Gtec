package com.Gtec.ProjetoGtec.dto.request;

import lombok.Getter;

@Getter
public class ImovelRequestDTO {


    private int dormitorios;

    private double valorAluguel;

    private double valorCondominio;

    private double valorIptu;

    private double valorTaxaIncendio;

    private String cep;

    private String logradouro;

    private String bairro;

    private String complemento;
}
