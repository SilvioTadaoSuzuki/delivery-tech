package com.deliverytech.delivery_api.dto.request;

//import org.hibernate.annotations.EmbeddableInstantiator;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
//Gera getters/seters
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    //Valida formato de email.
    private String email;
    @NotBlank
    private String telefone;
}

//Como usar: Recebe os dados do usuário ao criar/editar cliente, já validando.