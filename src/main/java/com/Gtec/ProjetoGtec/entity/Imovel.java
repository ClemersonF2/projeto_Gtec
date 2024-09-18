package com.Gtec.ProjetoGtec.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table ( name = "tb_imovel")
@SequenceGenerator( name = "imovel_seq",sequenceName = "imovel_seq",initialValue = 1,allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "imovel_seq")
    @Column (name = "id", nullable = false)
    private Long id;

    @Column (name = "dormitorios")
    private int dormitorios;

    @Column (name = "valorAluguel")
    private double valorAluguel;

    @Column (name = "valorCondominio")
    private double valorCondominio;

    @Column (name = "valorIptu")
    private double valorIptu;

    @Column (name = "ValorTaxaIncendio")
    private double valorTaxaIncendio;

    @Column (name = "cep")
    private String cep;

    @Column (name = "logradouro")
    private String logradouro;

    @Column (name = "bairro")
    private String bairro;

    @Column (name = "complemento")
    private String complemento;


    @Builder
    public Imovel(Long id, int dormitorios, double valorAluguel, double valorCondominio, double valorIptu, double valorTaxaIncendio, String complemento, String bairro, String logradouro, String cep) {
        this.id = id;
        this.dormitorios = dormitorios;
        this.valorAluguel = valorAluguel;
        this.valorCondominio = valorCondominio;
        this.valorIptu = valorIptu;
        this.valorTaxaIncendio = valorTaxaIncendio;
        this.complemento = complemento;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cep = cep;
    }


    public Imovel(Imovel imovel) {

    }
}




