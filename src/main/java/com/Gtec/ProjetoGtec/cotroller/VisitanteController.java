package com.Gtec.ProjetoGtec.cotroller;

import com.Gtec.ProjetoGtec.dto.request.VisitanteRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.VisitanteResponseDTO;
import com.Gtec.ProjetoGtec.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class VisitanteController {


    private final VisitanteService visitanteService;

    @GetMapping(value = "/visitantes/{id}")
    public ResponseEntity<VisitanteResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(visitanteService.findById(id));
    }

    @GetMapping(value ="/visitantes")
    public ResponseEntity<List<VisitanteResponseDTO>> findAll() {
        return ResponseEntity.ok().body(visitanteService.findAll());
    }

    @PostMapping(value = "/visitantes")
    public ResponseEntity<VisitanteResponseDTO> register(@RequestBody VisitanteRequestDTO visitanteRequestDTO, UriComponentsBuilder uriBuilder) {

        VisitanteResponseDTO visitanteResponseDTO = visitanteService.register(visitanteRequestDTO);

        URI uri = uriBuilder.path("/visitantes").buildAndExpand(visitanteResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(visitanteResponseDTO);
    }

    @PutMapping(value = "/visitantes/{id}")
    public ResponseEntity<VisitanteResponseDTO> update(@RequestBody VisitanteRequestDTO visitanteDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(visitanteService.update(id,visitanteDTO));
    }

    @DeleteMapping(value = "/visitantes/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(visitanteService.delete(id));
    }
}
