import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdotarComponent } from './adotar/adotar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { SobreComponent } from './sobre/sobre.component';

const routes: Routes = [
  {path:'Adotar', component:AdotarComponent},
  {path:'Cadastrar', component:CadastrarComponent},
  {path:'Sobre', component:SobreComponent},
  {path:'**', redirectTo: 'Adotar'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
