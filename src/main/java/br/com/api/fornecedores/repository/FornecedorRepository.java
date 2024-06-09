package br.com.api.fornecedores.repository;

import br.com.api.fornecedores.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
