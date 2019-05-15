import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/service/service.service';
import { Prato } from 'src/app/models/prato.model';
import { FormGroup} from "@angular/forms";

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {
  
  prato:Prato = new Prato();
  adicionarComponent:FormGroup;

  constructor(
    private router:Router,
    private service:ServiceService) { }

  ngOnInit() { }
  
  Salvar(prato:Prato){
    var array = JSON.parse("[\""+prato.acompanhamentos+"\"]");
    prato.acompanhamentos = array;
    this.service.salvarPratos(prato).
    subscribe(data=>{
      alert("Prato salvo com sucesso.");
      this.router.navigate(["listar"]);
    })
  }
}