import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-funcionario-form',
  templateUrl: './funcionario-form.component.html',
  styleUrls: ['./funcionario-form.component.css']
})
export class FuncionarioFormComponent implements OnInit {
  ultimoId = 0;

  nome = 'Leandro';
  adicionado = false;
  @Output() funcionarioAdicionado = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  adicionar() {
    this.adicionado = true;

    const funcionario = {
      id: Math.round(Math.random() * 98),
      nome: this.nome
    };
    this.funcionarioAdicionado.emit(funcionario);
  }

}
