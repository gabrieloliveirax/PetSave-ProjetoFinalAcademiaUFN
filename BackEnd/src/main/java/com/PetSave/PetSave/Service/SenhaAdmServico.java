package com.PetSave.PetSave.Service;

import com.PetSave.PetSave.Models.SenhaAdm;
import com.PetSave.PetSave.Repositories.SenhaAdmRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

// Anotação indicando que esta classe é um componente Spring (um serviço)
@Service
public class SenhaAdmServico {

    // Injeção de dependência do JavaMailSender para enviar e-mails
    @Autowired
    private JavaMailSender mailSender;

    // Injeção de dependência do repositório de SenhaAdm
    @Autowired
    private SenhaAdmRepositorio senhaAdmRepository;

    // Método para enviar uma nova senha por e-mail
    public void enviarSenha() {
        // Gerar uma nova senha
        String senha = gerarSenha();

        // Configurar a mensagem de e-mail
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo("gabrieligoroliveiraa@gmail.com");
        mensagem.setSubject("Sua senha de ADM");
        mensagem.setText("Senha: " + senha);

        // Enviar a mensagem de e-mail
        mailSender.send(mensagem);

        // Criar uma nova instância de SenhaAdm com a senha gerada
        SenhaAdm senhaAdm = new SenhaAdm();
        senhaAdm.setSenha(senha);

        // Salvar a senha no banco de dados
        senhaAdmRepository.save(senhaAdm);
    }

    // Método para gerar uma senha aleatória
    public String gerarSenha() {
        return Integer.toString(new Random().nextInt(999999) + 999999);
    }

    // Método para verificar se a senha fornecida é válida
    public boolean verificarSenha(String senha) {
        // Obter todas as senhas de admin do repositório
        List<SenhaAdm> todasSenhas = senhaAdmRepository.findAll();

        // Verificar se a senha fornecida corresponde a qualquer uma das senhas armazenadas
        for (SenhaAdm senhaAdm : todasSenhas) {
            if (senhaAdm.getSenha().equals(senha)) {
                return true;  // Senha válida
            }
        }
        return false;  // Senha inválida
    }
}
