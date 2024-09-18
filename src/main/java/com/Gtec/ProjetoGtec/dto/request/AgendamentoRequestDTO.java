package com.Gtec.ProjetoGtec.dto.request;

import com.Gtec.ProjetoGtec.entity.Funcionario;
import com.Gtec.ProjetoGtec.entity.Imovel;
import com.Gtec.ProjetoGtec.entity.Visitante;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class AgendamentoRequestDTO {

    private Long id;

    private Date data;

    private Time hora;

    private Imovel imovel;

    private Visitante visitante;

    private Funcionario funcionario;
}
