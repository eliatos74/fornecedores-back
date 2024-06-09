package br.com.api.fornecedores.web.dto.mappers;

import br.com.api.fornecedores.entity.Fornecedor;
import br.com.api.fornecedores.web.dto.FornecedorCreateDTO;
import br.com.api.fornecedores.web.dto.FornecedorResponseDTO;
import br.com.api.fornecedores.web.dto.FornecedorUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FornecedorMapper {

    public Fornecedor toFornecedor(FornecedorCreateDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setName(fornecedorDTO.name());
        fornecedor.setLastName(fornecedorDTO.lastName());
        fornecedor.setEmail(fornecedorDTO.email());
        fornecedor.setAddress(fornecedorDTO.address());
        return fornecedor;
    }

    public FornecedorResponseDTO toDTO(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getName(),
                fornecedor.getLastName(),
                fornecedor.getEmail(),
                fornecedor.getAddress()
        );
    }

    public Fornecedor toFornecedorUpdate(FornecedorUpdateDTO fornecedorUpdateDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setName(fornecedorUpdateDTO.name());
        fornecedor.setLastName(fornecedorUpdateDTO.lastName());
        fornecedor.setEmail(fornecedorUpdateDTO.email());
        fornecedor.setAddress(fornecedorUpdateDTO.address());
        return fornecedor;
    }

    public List<FornecedorResponseDTO> toListDTO(List<Fornecedor> fornecedorList) {
        List<FornecedorResponseDTO> listDTO = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedorList) {
            listDTO.add(toDTO(fornecedor));
        }
        return listDTO;

    }
}
