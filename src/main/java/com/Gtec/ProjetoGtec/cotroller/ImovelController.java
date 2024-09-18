package com.Gtec.ProjetoGtec.cotroller;

import com.Gtec.ProjetoGtec.dto.request.ImovelRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.ImovelResponseDTO;
import com.Gtec.ProjetoGtec.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class ImovelController {
    private final ImovelService imovelService;

    @GetMapping(value = "/imovels/{id}")
    public ResponseEntity<ImovelResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(imovelService.findById(id));
    }

    @GetMapping(value ="/imovels")
    public ResponseEntity<List<ImovelResponseDTO>> findAll() {
        return ResponseEntity.ok().body(imovelService.findAll());
    }

    @PostMapping(value = "/imovels")
    public ResponseEntity<ImovelResponseDTO> register(@RequestBody ImovelRequestDTO imovelRequestDTO, UriComponentsBuilder uriBuilder) {

        ImovelResponseDTO imovelResponseDTO = imovelService.register(imovelRequestDTO);

        URI uri = uriBuilder.path("/imovels").buildAndExpand(imovelResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(imovelResponseDTO);
    }

    @PutMapping(value = "/imovels/{id}")
    public ResponseEntity<ImovelResponseDTO> update(@RequestBody ImovelRequestDTO imovelDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(imovelService.update(id,imovelDTO));
    }

    @DeleteMapping(value = "/imovels/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(imovelService.delete(id));
    }
}
