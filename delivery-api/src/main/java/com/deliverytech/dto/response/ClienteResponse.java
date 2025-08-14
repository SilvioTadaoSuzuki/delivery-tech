package com.deliverytech.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;
}

//Como usar: Retorna dados ao usuário, sem expor toda a entidade Cliente.