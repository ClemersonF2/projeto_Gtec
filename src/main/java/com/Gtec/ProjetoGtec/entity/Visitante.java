package com.Gtec.ProjetoGtec.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Persistent;

import java.util.Collection;
import java.util.Set;

@SuperBuilder
@Entity
@Table(name = "TB_visitante")
@Getter
@Setter
@NoArgsConstructor
@Persistent
@SequenceGenerator( name = "visitante_seq",sequenceName = "visitante_seq",initialValue = 1,allocationSize = 1)
public class Visitante extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "funcionario_seq")
    @Column(name = "id", nullable = false, unique = true)

    private Long id;

    @Column(name = "renda_mensal")
    private double renda_mensal;



    public Visitante(Long id, String nome, String documento, String telefone, String email,double renda_mensal) {
        super (id, nome, documento, telefone, email);
        this.renda_mensal = renda_mensal;
    }


}
