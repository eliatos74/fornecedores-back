package br.com.api.fornecedores.web.controller;

import br.com.api.fornecedores.entity.Fornecedor;
import br.com.api.fornecedores.service.FornecedorService;
import br.com.api.fornecedores.web.dto.FornecedorCreateDTO;
import br.com.api.fornecedores.web.dto.FornecedorResponseDTO;
import br.com.api.fornecedores.web.dto.FornecedorUpdateDTO;
import br.com.api.fornecedores.web.dto.mappers.FornecedorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;
    private final FornecedorMapper fornecedorMapper;


    @PostMapping
    public ResponseEntity<FornecedorResponseDTO> create(@Valid @RequestBody FornecedorCreateDTO request) {
        Fornecedor fornecedor = fornecedorService.criar(fornecedorMapper.toFornecedor(request));
        var response = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> getById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.buscarPorId(id);
        var response = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FornecedorUpdateDTO request) {
        Fornecedor fornecedor = fornecedorService.editar(id,fornecedorMapper.toFornecedorUpdate(request));
        System.out.println(fornecedor.toString());
        var response = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> getAll() {
        List<Fornecedor> fornecedorList = fornecedorService.buscarTodos();
        var response = fornecedorMapper.toListDTO(fornecedorList);
        return ResponseEntity.ok(response);
    }
}
