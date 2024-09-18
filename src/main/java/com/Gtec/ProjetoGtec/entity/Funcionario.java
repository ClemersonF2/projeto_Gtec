package com.Gtec.ProjetoGtec.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Persistent;

import java.util.Set;


@Entity
@Persistent
@Table(name = "tb_funcionario")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

@SequenceGenerator( name = "funcionario_seq",sequenceName = "funcionario_seq",initialValue = 1,allocationSize = 1)
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "funcionario_seq")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "matricula")
    private String matricula;


    public Funcionario(Long id, String nome, String documento, String telefone, String email, String matricula) {
        super(id, nome, documento, telefone, email);
        this.matricula = matricula;
    }

}