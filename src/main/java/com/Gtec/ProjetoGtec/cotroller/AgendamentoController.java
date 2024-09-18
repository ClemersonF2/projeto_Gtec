package com.Gtec.ProjetoGtec.cotroller;

import com.Gtec.ProjetoGtec.dto.request.AgendamentoRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.AgendamentoResponseDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.entity.Funcionario;
import com.Gtec.ProjetoGtec.entity.Imovel;
import com.Gtec.ProjetoGtec.entity.Visitante;
import com.Gtec.ProjetoGtec.repository.FuncionarioRepository;
import com.Gtec.ProjetoGtec.repository.ImovelRepository;
import com.Gtec.ProjetoGtec.repository.VisitanteRepository;
import com.Gtec.ProjetoGtec.service.AgendamentoService;
import com.Gtec.ProjetoGtec.util.AgendamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    private final ImovelRepository imovelRepository;
    private final VisitanteRepository visitanteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final AgendamentoMapper agdMapper;

    @GetMapping(value = "/agendamentos/{id}")
    public ResponseEntity<AgendamentoResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(agendamentoService.findById(id));
    }

    @GetMapping(value ="/agendamentos")
    public ResponseEntity<List<AgendamentoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(agendamentoService.findAll());
    }

    @PostMapping(value = "/agendamentos")
    public ResponseEntity<AgendamentoResponseDTO> register(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO, UriComponentsBuilder uriBuilder) {
        // Pesquisar dados do imovel e retorna o id
        Optional<Imovel> imov = Optional.of(new Imovel());
        imov = imovelRepository.findById(agendamentoRequestDTO.getImovel().getId());
        agendamentoRequestDTO.getImovel().setId(imov.get().getId());

        // Pesquisar dados do visitante e retorna o id
        Optional<Visitante> visit = Optional.of(new Visitante());
        visit = visitanteRepository.findById(agendamentoRequestDTO.getVisitante().getId());
        agendamentoRequestDTO.getVisitante().setId(visit.get().getId());

        // Pesquisar dados do funcionario e retorna o id
        Optional<Funcionario> func = Optional.of(new Funcionario());
        func = funcionarioRepository.findById(agendamentoRequestDTO.getFuncionario().getId());
        agendamentoRequestDTO.getFuncionario().setId(func.get().getId());

        AgendamentoResponseDTO agendamentoResponseDTO = agendamentoService.register(agendamentoRequestDTO);

        agendamentoResponseDTO.setVisitante(agdMapper.retornaVisitante(visit));
        agendamentoResponseDTO.setFuncionario(agdMapper.retornaFuncionario(func));
        agendamentoResponseDTO.setImovel(agdMapper.retornaImovel(imov));

        URI uri = uriBuilder.path("/agendamentos").buildAndExpand(agendamentoResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(agendamentoResponseDTO);
    }

    @PutMapping(value = "/agendamentos/{id}")
    public ResponseEntity<AgendamentoResponseDTO> update(@RequestBody AgendamentoRequestDTO agendamentoDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(agendamentoService.update(id,agendamentoDTO));
    }

    @DeleteMapping(value = "/agendamentos/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(agendamentoService.delete(id));
    }
}
