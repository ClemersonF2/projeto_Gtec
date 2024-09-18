package com.Gtec.ProjetoGtec.cotroller;

import com.Gtec.ProjetoGtec.dto.request.FuncionarioRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.FuncionarioResponseDTO;
import com.Gtec.ProjetoGtec.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping(value = "/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(funcionarioService.findById(id));
    }

    @GetMapping(value ="/funcionarios")
    public ResponseEntity<List<FuncionarioResponseDTO>> findAll() {
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }

    @PostMapping(value = "/funcionarios")
    public ResponseEntity<FuncionarioResponseDTO> register(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO, UriComponentsBuilder uriBuilder) {

        FuncionarioResponseDTO funcionarioResponseDTO = funcionarioService.register(funcionarioRequestDTO);

        URI uri = uriBuilder.path("/funcionarios").buildAndExpand(funcionarioResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(funcionarioResponseDTO);
    }

    @PutMapping(value = "/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponseDTO> update(@RequestBody FuncionarioRequestDTO funcionarioDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(funcionarioService.update(id,funcionarioDTO));
    }

    @DeleteMapping(value = "/funcionarios/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(funcionarioService.delete(id));
    }
}
