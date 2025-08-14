package com.deliverytech.service;

import com.deliverytech.dto.request.ClienteRequest;
import com.deliverytech.dto.response.ClienteResponse;
import java.util.List;

public interface ClienteService {
    ClienteResponse criar(ClienteRequest request);
    List<ClienteResponse> listar();
    ClienteResponse buscarPorId(Long id);
    ClienteResponse atualizar(Long id, ClienteRequest request);
    void deletar(Long id);
}

//Como usar: Define o contrato das operações de cliente.