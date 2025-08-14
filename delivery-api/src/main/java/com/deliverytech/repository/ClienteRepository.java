package com.deliverytech.repository;

import com.deliverytech.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    //Consulta customizada
}

//Como usar: Permite buscar, salvar, atualizar e deletar clientes facilmente.