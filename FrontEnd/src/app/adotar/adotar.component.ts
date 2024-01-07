import { Component } from '@angular/core';
import { Pets } from '../../models/pets';
import { PetsService } from '../pets.service';

@Component({
  selector: 'app-adotar',
  templateUrl: './adotar.component.html',
  styleUrls: ['./adotar.component.css']
})
export class AdotarComponent {
  pets = new Pets(); // Instância de Pets para armazenar dados do novo pet
  petss: Pets[] = []; // Lista de Pets para armazenar pets disponíveis para adoção
  senha: string = ''; // Variável para armazenar a senha inserida pelo usuário
  senhaCorreta: boolean = false; // Indica se a senha inserida está correta

  constructor(private service: PetsService) {}

  // Método para carregar a lista de pets disponíveis ao inicializar o componente
  selecionar(): void {
    this.service.selecionar().subscribe(retornar => (this.petss = retornar));
  }

  // Método chamado ao inicializar o componente
  ngOnInit() {
    this.selecionar();
  }

  // Método para entrar em contato com o dono do pet via WhatsApp
  contato(pet: Pets): void {
    let msg = `Olá, tudo bem? Tenho interesse na adoção do pet ${pet.nome}!`;
    let wpp = `https://wa.me/${pet.numeroParaContato}?text=${encodeURIComponent(msg)}`;
    window.open(wpp, '_blank');
  }

  // Método para verificar se a senha inserida está correta
  verificarSenha() {
    const senhaCorreta = '321123';
    this.senhaCorreta = this.senha === senhaCorreta;
  }

  // Método para atualizar o status de adoção de um pet
  atualizarStatus(idPet: number, event: Event) {
    const selectElement = event.target as HTMLSelectElement | null;
    if (selectElement) {
      const novoStatus = selectElement.value;
      const pata = this.petss.find(p => p.id === idPet);
      if (pata) {
        pata.statusAdocao = novoStatus;
        this.service.editar(pata).subscribe();
      }
    }
  }
}
