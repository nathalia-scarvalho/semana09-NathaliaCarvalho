package Curso.API.controller;

import Curso.API.fabricante.DadosFabricante;
import Curso.API.fabricante.FabricanteDTO;
import Curso.API.fabricante.FabricanteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> adicionarFabricante(@RequestBody DadosFabricante dadosFabricante) {
        FabricanteDTO fabricanteDTO = fabricanteService.adicionarFabricante(dadosFabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteDTO);
    }
    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> listarFabricantes(Pageable pageable) {
        List<FabricanteDTO> fabricantes = fabricanteService.listarFabricante(pageable)
                .stream()
                .map(fabricante -> FabricanteDTO.fromFabricante(fabricante))
                .collect(Collectors.toList());
        return ResponseEntity.ok(fabricantes);
    }
}

