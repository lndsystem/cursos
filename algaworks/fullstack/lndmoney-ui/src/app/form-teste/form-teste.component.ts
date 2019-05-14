import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

class Cliente {
  nome: string;
  email: string;
  profissao: string;
}

@Component({
  selector: 'app-form-teste',
  templateUrl: './form-teste.component.html',
  styleUrls: ['./form-teste.component.css']
})
export class FormTesteComponent implements OnInit {

  profissoes = ['Programador', 'Empresário', 'Outros'];

  cliente = new Cliente();

  constructor() { }

  ngOnInit() {
  }


  salvar(form: NgForm) {
    // this.cliente.nome = form.value.nome;
    // this.cliente.email = form.value.email;
    // this.cliente.profissao = form.value.profissao;

    console.log(this.cliente);
  }

}
