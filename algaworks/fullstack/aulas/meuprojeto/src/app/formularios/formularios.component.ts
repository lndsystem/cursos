import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

class Cliente {
  nome: string;
  email: string;
  profissao = '';
}

@Component({
  selector: 'app-formularios',
  templateUrl: './formularios.component.html',
  styleUrls: ['./formularios.component.css']
})
export class FormulariosComponent implements OnInit {

  cliente = new Cliente();
  profissoes = ['Programador', 'Empresário', 'Outra'];
  profissao = this.profissoes[2];

  constructor() { }

  ngOnInit() {
  }

  salvar(form: NgForm) {
    // this.cliente.nome = form.value.nome;
    // this.cliente.email = form.value.email;
    // this.cliente.profissao = form.value.profissao;

    console.log(form);
    this.cliente = new Cliente();
    form.reset({profissao: ''});
  }
}
