package com.barbershop.barbershop.api.controllers;

import com.barbershop.barbershop.api.DTO.ClientRequestDTO;
import com.barbershop.barbershop.api.DTO.ClientResponseDTO;
import com.barbershop.barbershop.api.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/clients/v1")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll(){
        List<ClientResponseDTO> response = service.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id){
        ClientResponseDTO response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> insert(@Valid @RequestBody ClientRequestDTO dto){
        ClientResponseDTO response = service.insertClient(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);

    }

}
