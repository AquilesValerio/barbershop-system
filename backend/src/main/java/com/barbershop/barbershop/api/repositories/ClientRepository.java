package com.barbershop.barbershop.api.repositories;

import com.barbershop.barbershop.api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findByPhone(String phone);
    public boolean existsByPhone(String phone);
    public String existsByName(String name);

}
