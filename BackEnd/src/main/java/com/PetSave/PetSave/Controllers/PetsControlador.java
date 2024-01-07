package com.PetSave.PetSave.Controllers;

import com.PetSave.PetSave.Models.Pets;
import com.PetSave.PetSave.Repositories.PetsRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Anotação indicando que esta classe é um controlador REST
@RestController
// Mapeamento da URL base para todas as requisições neste controlador
@RequestMapping("Pets")
// Habilita o acesso a este controlador a partir de qualquer origem (Cross-Origin Resource Sharing)
@CrossOrigin(origins = "*")
public class PetsControlador {

    // Injeção de dependência do repositório de Pets
    @Autowired
    private PetsRepositorio petsRepositorio;

    // Método para lidar com requisições POST para cadastrar um novo Pet
    @PostMapping("/")
    public Pets cadastrar(@RequestBody Pets c){
        // Salva o Pet no repositório e retorna o objeto salvo
        return petsRepositorio.save(c);
    }

    // Método para lidar com requisições GET para obter todos os Pets cadastrados
    @GetMapping("/")
    public Iterable<Pets> selecionar(){
        // Retorna todos os Pets do repositório
        return petsRepositorio.findAll();
    }

    // Método para lidar com requisições PUT para editar um Pet existente
    @PutMapping("/")
    public Pets editar(@RequestBody Pets c){
        // Salva as alterações no Pet no repositório e retorna o objeto salvo
        return petsRepositorio.save(c);
    }

    // Método para lidar com requisições DELETE para remover um Pet pelo ID
    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id){
        // Remove o Pet do repositório pelo ID
        petsRepositorio.deleteById(id);
    }
}
