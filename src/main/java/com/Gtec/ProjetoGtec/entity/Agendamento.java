package com.Gtec.ProjetoGtec.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "tb_agendamento")
@SequenceGenerator( name = "agendamento_seq",sequenceName = "agemdamento_seq",initialValue = 1,allocationSize = 1)
@NoArgsConstructor
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "agendamento_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora", nullable = false)
    private Time hora;

    @JoinColumn(name = "visitante_id", referencedColumnName = "id")
    @ManyToOne
    private Visitante visitante;

    @JoinColumn(name = "funcionario_id",referencedColumnName = "id")

    @ManyToOne
    private Funcionario funcionario;


   @JoinColumn(name = "imovel_id",referencedColumnName = "id")
   @ManyToOne
    private Imovel imovel;



   @Builder
    public Agendamento(Long id, Date data, Time hora, Visitante visitante, Funcionario funcionario, Imovel imovel) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.visitante = visitante;
        this.funcionario = funcionario;
        this.imovel = imovel;
    }
}



