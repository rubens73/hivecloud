import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './prato/listar/listar.component';
import { AdicionarComponent } from './prato/adicionar/adicionar.component';
import { EditarComponent } from './prato/editar/editar.component';

const routes: Routes = [
  {path:'listar', component:ListarComponent},
  {path:'adicionar', component:AdicionarComponent},
  {path:'editar', component:EditarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
