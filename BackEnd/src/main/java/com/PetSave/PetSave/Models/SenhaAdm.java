package com.PetSave.PetSave.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

// Anotação indicando que esta classe é uma entidade JPA (Java Persistence API)
@Entity
public class SenhaAdm {

    // Anotação indicando que este campo é a chave primária da entidade e será gerenciado automaticamente pelo banco de dados
    @Id
    // Anotação indicando que a geração do valor da chave primária será feita de forma automática pelo banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Campo que armazena a senha administrativa
    private String senha;

    // Campo que armazena a data de criação da senha (utilizando LocalDateTime para representar data e hora)
    private LocalDateTime data;

    // Construtor padrão que define a data de criação como o momento atual
    public SenhaAdm() {
        this.data = LocalDateTime.now();
    }

    // Métodos getter e setter para acessar e modificar os campos da classe
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
