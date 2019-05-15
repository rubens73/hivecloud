import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Prato }  from '../../models/prato.model';
import { ServiceService } from '../../service/service.service'

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  pratos:Prato[];
  constructor(private router: Router, private pratoService: ServiceService) {}

  ngOnInit() {
    this.pratoService.getPratos()
      .subscribe( data => {
        this.pratos = data;
      });
  };

  Salvar(prato:Prato){ 
    this.pratoService.salvarPratos(prato)
    .subscribe(data=>{
      alert("Prato salvo com sucesso.");
      this.router.navigate(["listar"]);
    })
  }

  Deletar(prato:Prato){
    this.pratoService.deletarPrato(prato)
    .subscribe(data=>{
      this.pratos=this.pratos.filter(p => p!=prato);
      alert("Prato apagado.");
    })
  }

  Editar(prato:Prato):void{
    localStorage.setItem("nome",prato.nome.toString());
    this.router.navigate(["editar"]);
  }
  
  Pedido():void{
    alert("Funcionalidade em desenvolvimento")
  }
}
