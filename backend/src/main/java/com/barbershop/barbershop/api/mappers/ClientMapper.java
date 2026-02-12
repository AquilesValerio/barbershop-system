package com.barbershop.barbershop.api.mappers;

import com.barbershop.barbershop.api.DTO.ClientRequestDTO;
import com.barbershop.barbershop.api.DTO.ClientResponseDTO;
import com.barbershop.barbershop.api.entities.Client;

import java.util.List;

public class ClientMapper {

    public static Client toEntity (ClientRequestDTO dto){
        Client client = new Client(dto.name(), dto.email(), dto.phone());
        return client;
    }

    public static ClientResponseDTO toDto(Client entity){
        ClientResponseDTO dto = new ClientResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone());
        return dto;
    }

    public static List<ClientResponseDTO> toDtoList(List<Client> clientList){
        return clientList.stream().map((c) -> toDto(c)).toList();
    }
}
