package com.Gtec.ProjetoGtec.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.web.WebProperties;
import java.io.Serializable;


@Entity
@Table(name = "tb_pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;


    @Column (name = "nome")
    private String nome;

    @Column (name = "documento")
    private String documento;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "email")
    private String email;

}

