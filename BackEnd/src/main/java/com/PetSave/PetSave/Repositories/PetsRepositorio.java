package com.PetSave.PetSave.Repositories;

import com.PetSave.PetSave.Models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository para fornecer operações básicas de CRUD para a entidade Pets
public interface PetsRepositorio extends JpaRepository<Pets, Long> {
    // Nenhuma implementação adicional é necessária, pois JpaRepository já fornece métodos como save, findById, findAll, delete, etc.
}
