package com.deliverytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Log> {
    boolean existsByEmail(String email);
    //Método customizado

}
