import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-funcionario-card',
  templateUrl: './funcionario-card.component.html',
  // styleUrls: ['./funcionario-card.component.css']
  styles: [`
    .card-body {
      text-transform: uppercase;
      color: blue;
    }
  `]
})
export class FuncionarioCardComponent implements OnInit {

  @Input() funcionario: any;

  constructor() { }

  ngOnInit() {
  }

  getEstilosCartao() {
    return {backgroundColor : this.funcionario.id % 2 === 0 ? 'lightblue' : 'lightgreen'};
  }

  isAdmin() {
    return this.funcionario.nome.startsWith('L');
  }



}
