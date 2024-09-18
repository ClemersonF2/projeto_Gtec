package com.Gtec.ProjetoGtec.dto.response;

import com.Gtec.ProjetoGtec.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class AgendamentoResponseDTO {

    private Long id;

    private Date data;

    private Time hora;

    private Imovel imovel;

    private Visitante visitante;

    private Funcionario funcionario;

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.hora = agendamento.getHora();
        this.imovel = agendamento.getImovel();
        this.visitante = agendamento.getVisitante();
        this.funcionario = agendamento.getFuncionario();
    }
}
