package br.com.api.fornecedores.service;

import br.com.api.fornecedores.entity.Fornecedor;
import br.com.api.fornecedores.exception.EntityNotFoundException;
import br.com.api.fornecedores.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    @Transactional
    public Fornecedor criar(Fornecedor fornecedor) {
//        try {
        return fornecedorRepository.save(fornecedor);
//        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
//            throw new EmailUniqueViolationException(String.format("E-mail {%s} já cadastrado", fornecedor.getEmail()));
//        }
    }

    @Transactional(readOnly = true)
    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Fornecedor com id = %s não encontrado.", id))
        );
    }

    @Transactional
    public Fornecedor editar(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Fornecedor com id = %s não encontrado.", id))
        );
        fornecedor.setName(fornecedorAtualizado.getName());
        fornecedor.setLastName(fornecedorAtualizado.getLastName());
        fornecedor.setEmail(fornecedorAtualizado.getEmail());
        fornecedor.setAddress(fornecedorAtualizado.getAddress());
        return fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public void excluir(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Fornecedor com id = %s não encontrado.", id));
        }
        fornecedorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

}
