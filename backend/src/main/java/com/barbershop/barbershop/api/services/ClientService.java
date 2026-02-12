package com.barbershop.barbershop.api.services;

import com.barbershop.barbershop.api.DTO.ClientRequestDTO;
import com.barbershop.barbershop.api.DTO.ClientResponseDTO;
import com.barbershop.barbershop.api.entities.Client;
import com.barbershop.barbershop.api.exceptions.services.BadRequestException;
import com.barbershop.barbershop.api.exceptions.services.ResourceNotFoundException;
import com.barbershop.barbershop.api.mappers.ClientMapper;
import com.barbershop.barbershop.api.repositories.ClientRepository;
import com.barbershop.barbershop.api.validator.PhoneValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientResponseDTO> findAll(){
        List<Client> clientList = repository.findAll();
        return ClientMapper.toDtoList(clientList);
    }

    public ClientResponseDTO findById(Long id){
        Client entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado"));
        return ClientMapper.toDto(entity);
    }

    public ClientResponseDTO insertClient(ClientRequestDTO dto) {
        PhoneValidator.validatePhone(dto.phone());
        existClient(dto.phone());
        Client entity = ClientMapper.toEntity(dto);
        Client saved = repository.save(entity);
        return ClientMapper.toDto(saved);
    }

    private void existClient(String phone){
        if(repository.existsByPhone(phone)){
            throw new BadRequestException("Telefone já cadastrado." + phone);
        }
    }

    //TODO: ✔ Criar validação por email e CPF
     //TODO:✔ Centralizar mensagens de erro em ENUM
    //TODO:✔ Criar ErrorResponse padronizado estilo Spring Boot 3
    //TODO:✔ Adicionar Bean Validation (ex: @Email, @Size, @NotBlank)
    //TODO:✔ Criar testes unitários para sua regra de unicidade -->  [https://chatgpt.com/c/692316f1-cee0-8331-88e9-0e9be31807a8]

}



