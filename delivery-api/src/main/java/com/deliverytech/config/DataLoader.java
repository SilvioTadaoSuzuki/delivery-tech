package com.deliverytech.config;

import com.deliverytech.model.Cliente;
import com.deliverytech.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Seeds initial Cliente data for local runs and tests.
 * Idempotent: checks email uniqueness before inserting.
 */

 @Component
 //Torna a classe um bean gerenciado pelo Spring.
 @RequiredArgsConstructor
 //Gera constructor com os campos finais.

public class DataLoader implements CommandLineRunner {
    
    private final ClienteRepository ClienteRepository;

    @Override
    public void run (String... args) {
        //Cria clientes de exemplo de testes.
        List<Cliente> seeds = List.of(
            Cliente.builder()
            .nome ("João Silva")
            .email ("joao.silva@teste.com")
            .telefone ("(19)98765-4321")
            .ativo (true)
            .build(),

            Cliente.builder()
            .nome ("Ana Souza")
            .email ("ana.souza@teste.com")
            .telefone ("(11)32145-6789")
            .ativo (true)
            .build(),

            Cliente.builder()
            .nome ("Pedro Santos")
            .email ("pedro.santos@teste.com")
            .telefone ("(21)96385-2741")
            .ativo (true)
            .build()

        );

    //Insere apenas se o email não existir, evitando duplicidade.
    seeds.forEach(c -> {
        if (!clienteRepository.existsByEmail(c.getEmail())) {
            clienteRepository.save(c);
        }
    });

    }

}

//Como usar: Essa classe roda automaticamente ao iniciar a aplicação (CommandLineRunner). Serve para inserir dados de teste no banco.
