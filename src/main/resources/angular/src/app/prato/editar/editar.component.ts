import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/service/service.service';
import { Prato } from 'src/app/models/prato.model';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  prato:Prato = new Prato();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let nome = localStorage.getItem("nome");
    this.service.getPratoId(nome)
    .subscribe(data=>{
      this.prato=data;
    })
  }

  Atualizar(prato:Prato){
    var array = JSON.parse("[\""+prato.acompanhamentos+"\"]");
    prato.acompanhamentos = array;
    this.service.editarPrato(prato)
    .subscribe(data=>{
      this.prato=data;
      alert("Atualizado com sucesso.");
      this.router.navigate(["listar"]);
    })
  }

}
