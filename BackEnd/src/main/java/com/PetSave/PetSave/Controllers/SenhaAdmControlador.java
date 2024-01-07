package com.PetSave.PetSave.Controllers;

import com.PetSave.PetSave.Models.SenhaAdm;
import com.PetSave.PetSave.SenhaDto;
import com.PetSave.PetSave.Service.SenhaAdmServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Anotação indicando que esta classe é um controlador REST
@RestController
// Mapeamento da URL base para todas as requisições neste controlador
@RequestMapping("SenhaAdm")
// Habilita o acesso a este controlador a partir de qualquer origem (Cross-Origin Resource Sharing)
@CrossOrigin(origins = "*")
public class SenhaAdmControlador {

    // Injeção de dependência do serviço de SenhaAdm
    @Autowired
    private SenhaAdmServico senhaAdmServico;

    // Método para lidar com requisições POST para enviar uma senha
    @PostMapping("/enviar")
    public ResponseEntity<?> enviarSenha(){
        // Chama o método no serviço para enviar a senha e retorna uma resposta de sucesso
        senhaAdmServico.enviarSenha();
        return ResponseEntity.ok("Código enviado");
    }

    // Método para lidar com requisições POST para verificar uma senha
    @PostMapping("/verificar")
    public ResponseEntity<String> validarSenha(@RequestBody SenhaDto senhaDTO) {
        // Verifica se a senha fornecida é correta usando o serviço
        if (senhaAdmServico.verificarSenha(senhaDTO.getSenha())) {
            // Retorna uma resposta de sucesso se a senha estiver correta
            return ResponseEntity.ok("Senha correta");
        } else {
            // Retorna uma resposta não autorizada se a senha estiver incorreta
            return ResponseEntity.status(401).body("Senha incorreta");
        }
    }
}
