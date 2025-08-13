package com.deliverytech.controller;

import com.deliverytech.dto.request.ClienteRequest;
import com.deliverytech.dto.response.ClienteResponse;
import com.deliverytech.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//Indica que é um controlador REST.
@RequestMapping("/api/clientes")
//Define o caminho base dos endpoints.
@RequiredArgsConstructor
//Injeta dependências final via construtor.
@Tag(name = "Cliente", description = "Operações relacionadas ao gerenciamento")
public class ClienteController {
    
    private final ClienteService clienteService;

    @PostMapping
    //Endpoint para criar cliente.
    public ResponseEntity<ClienteResponse> criar(@RequestBody @Valid Cliente) { //REVISAR
        return ResponseEntity.status(201).body(clienteService.criar(request));
    }

    @GetMapping
    //Endpoint para listar todos os clientes.
    public List<ClienteResponse> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    //Endpoint para buscar cliente por ID.
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {//REVISAR
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    //Endpoint para atualizar cliente.
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteRequest request) {
        return ResponseEntity.ok(clienteService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    //Endpoint para deletar cliente.
    public ResponseEntity<Void> deletar(PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

//Como usar: Mapeia rotas HTTP para métodos Java, chamando o serviço apropriado.