import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pets } from '../models/pets';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PetsService {
  private url: string = 'http://localhost:8090/Pets/'; // URL da API para manipulação de Pets

  constructor(private http: HttpClient) {}

  // Método para cadastrar um novo pet
  cadastrar(objeto: Pets): Observable<Pets> {
    return this.http.post<Pets>(this.url, objeto);
  }

  // Método para obter a lista de pets disponíveis
  selecionar(): Observable<Pets[]> {
    return this.http.get<Pets[]>(this.url);
  }

  // Método para editar informações de um pet existente
  editar(objeto: Pets): Observable<Pets> {
    return this.http.put<Pets>(this.url, objeto);
  }
}
