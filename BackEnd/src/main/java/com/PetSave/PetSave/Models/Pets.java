package com.PetSave.PetSave.Models;

import jakarta.persistence.*;
import lombok.Data;

// Anotação indicando que esta classe é uma entidade JPA (Java Persistence API)
@Entity
// Anotação do Lombok para gerar automaticamente getters, setters, toString, etc.
@Data
public class Pets {

    // Anotação indicando que este campo é a chave primária da entidade e será gerenciado automaticamente pelo banco de dados
    @Id
    // Anotação indicando que a geração do valor da chave primária será feita de forma automática pelo banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos que representam as características de um Pet
    private String nome;
    private String raca;
    private String numeroParaContato;
    private String descricao;
    private String statusAdocao;
}
