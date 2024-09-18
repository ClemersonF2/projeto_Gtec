package com.Gtec.ProjetoGtec.util;

import com.Gtec.ProjetoGtec.dto.request.AgendamentoRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.AgendamentoResponseDTO;
import com.Gtec.ProjetoGtec.entity.Agendamento;
import com.Gtec.ProjetoGtec.entity.Funcionario;
import com.Gtec.ProjetoGtec.entity.Imovel;
import com.Gtec.ProjetoGtec.entity.Visitante;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class AgendamentoMapper {

    public Agendamento toAgendamento(AgendamentoRequestDTO agendamentoDTO) {

        return Agendamento.builder()
                .data(agendamentoDTO.getData())
                .hora(agendamentoDTO.getHora())
                .imovel(agendamentoDTO.getImovel())
                .visitante(agendamentoDTO.getVisitante())
                .funcionario(agendamentoDTO.getFuncionario())

                .build();

    }

    public AgendamentoResponseDTO toAgendamentoDTO(Agendamento agendamento) {
        return new AgendamentoResponseDTO(agendamento);
    }

    public List<AgendamentoResponseDTO> toAgendamentoDTO(List<Agendamento> agendamentosList) {
        return agendamentosList.stream().map(AgendamentoResponseDTO::new).collect(Collectors.toList());
    }

    public void updateAgendamentoData(Agendamento agendamento, AgendamentoRequestDTO agendamentoDTO) {

        agendamento.setData(agendamentoDTO.getData());
        agendamento.setHora(agendamentoDTO.getHora());
        agendamento.setVisitante(agendamentoDTO.getVisitante());
        agendamento.setImovel(agendamentoDTO.getImovel());
        agendamento.setFuncionario(agendamentoDTO.getFuncionario());


    }

    public Visitante retornaVisitante(Optional<Visitante> optionVisitante) {
        Visitante visitante = new Visitante();

        visitante.setRenda_mensal(optionVisitante.get().getRenda_mensal());
        visitante.setNome(optionVisitante.get().getNome());
        visitante.setDocumento(optionVisitante.get().getDocumento());
        visitante.setEmail(optionVisitante.get().getEmail());
        visitante.setTelefone(optionVisitante.get().getTelefone());
        visitante.setId(optionVisitante.get().getId());

        return visitante;

    }
    public Funcionario retornaFuncionario(Optional<Funcionario> optionalFuncionario){
        Funcionario fucinario = new Funcionario();

        fucinario.setId(optionalFuncionario.get().getId());
        fucinario.setNome(optionalFuncionario.get().getNome());
        fucinario.setTelefone(optionalFuncionario.get().getTelefone());
        fucinario.setEmail(optionalFuncionario.get().getEmail());
        fucinario.setDocumento(optionalFuncionario.get().getDocumento());
        fucinario.setMatricula(optionalFuncionario.get().getMatricula());

        return fucinario;
    }

    public Imovel retornaImovel(Optional<Imovel> optionalImovel){
        Imovel imovel = new Imovel();

        imovel.setId(optionalImovel.get().getId());
        imovel.setBairro(optionalImovel.get().getBairro());
        imovel.setCep(optionalImovel.get().getCep());
        imovel.setComplemento(optionalImovel.get().getComplemento());
        imovel.setLogradouro(optionalImovel.get().getLogradouro());
        imovel.setValorIptu(optionalImovel.get().getValorIptu());
        imovel.setValorTaxaIncendio(optionalImovel.get().getValorTaxaIncendio());
        imovel.setValorCondominio(optionalImovel.get().getValorCondominio());
        imovel.setValorAluguel(optionalImovel.get().getValorAluguel());

        return imovel;



    }
}
