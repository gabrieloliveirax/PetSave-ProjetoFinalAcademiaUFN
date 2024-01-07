package com.PetSave.PetSave.Repositories;

import com.PetSave.PetSave.Models.SenhaAdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anotação indicando que esta interface é um repositório Spring
@Repository
// Interface que estende JpaRepository para fornecer operações básicas de CRUD para a entidade SenhaAdm
public interface SenhaAdmRepositorio extends JpaRepository<SenhaAdm, Long> {
    // Nenhuma implementação adicional é necessária, pois JpaRepository já fornece métodos como save, findById, findAll, delete, etc.
}
