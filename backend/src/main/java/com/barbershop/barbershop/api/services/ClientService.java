package com.barbershop.barbershop.api.services;

import com.barbershop.barbershop.api.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    private final ClientRepository repository;

    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

}
