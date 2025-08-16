package com.deliverytech.delivery_api.model;
//Define o pacote onde a classe está localizada.

import jakarta.persistence.*;
//Importa as anotações de persistência JPA.
import lombok.*;
//Importa as anotações do Lombok para reduzir código padrão.

/**
 * Representa a entidade Cliente, que será mapeada para uma tabela no banco.
 */

 @Entity
 //Diz ao JPA que essa classe é uma entidade (tabela no banco) - Lombok.
 @Data
 //Gera automaticamente getters, setters, equals, hashCode e toString - Lombok.
 @NoArgsConstructor
 //Gera um constructor sem argumentos - Jakarta.
 @AllArgsConstructor
 //Gera um constructor com todos os argumentos - Jakarta.
 @Builder
 //Permite construir clientes usando o padrão Builder - Lombok.

 public class Cliente {
    @Id
    //Marca o atributo como chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Gera o valor da chave primária
    private Long id;
    //Atributo que representa o identificador único do cliente.

    @Column(nullable = false)
    //Se "false", campo não pode ser nulo/branco.
    private String nome;
    //Nome do cliente.

    @Column(nullable = false, unique = true)
    //Campo não pode ser nulo e deve ser único.
    private String email;
    //Email do cliente usado para contato e login.

    @Column(nullable = false)
    //Campo não pode ser nulo.
    private String telefone;
    //Telefone do cliente.

    @Builder.Default
    //Define o valor padrão ao usar o Builder.
    private Boolean ativo = true;
    //Indica se o cliente está ativo ou não.

 }
 
 // **Explicação linha por linha**
 //- package: define onde a classe fica organizada no projeto.
 //- import: traz recursos necessários (JPA para persistência, Lombok para gerar código automaticamente).
 //- @Entity: indica que a classe vira uma tabela no banco.
 //- @Data, @NoArgsConstructor, @AllArgsConstructor, @Builder: geram automaticamente métodos essenciais, evitando código repetitivo.
 //- @Id, @GeneratedValue: define o campo id como chave primária e faz o banco gerar o valor.
 //- @Column: personaliza como cada campo é salvo no banco (por exemplo, não permitir nulo ou exigir unicidade).
 //- private: define os atributos da tabela/entidade.
 //- @Builder.Default: define que o campo ativo começa como "true" ao criar um cliente como builder.

 //Por que usar dessa forma? Organiza os dados, garante integridade no banco (ex: email único e obrigatório), e facilita criar/ler objetos Java do banco de dados.