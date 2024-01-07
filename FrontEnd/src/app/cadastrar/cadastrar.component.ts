import { Component } from '@angular/core';
import { Pets } from '../../models/pets';
import { PetsService } from '../pets.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent {
  pets = new Pets(); // Instância de Pets para armazenar dados do novo pet

  constructor(private service: PetsService) {}

  // Método para cadastrar um novo pet
  cadastrar(): void {
    console.log('Dados do formulário:', this.pets); // Exibe os dados do formulário no console (pode ser removido em produção)

    this.service.cadastrar(this.pets).subscribe(retorno => {
      console.log('Resposta do serviço:', retorno); // Exibe a resposta do serviço no console (pode ser removido em produção)
      alert('Cadastrado com sucesso'); // Exibe um alerta informando que o cadastro foi realizado com sucesso
      this.pets = new Pets(); // Limpa os dados do formulário após o cadastro
    });
  }
}
