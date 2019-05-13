import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pessoal-pesquisa',
  templateUrl: './pessoal-pesquisa.component.html',
  styleUrls: ['./pessoal-pesquisa.component.css']
})
export class PessoalPesquisaComponent implements OnInit {

  pessoas = [
    {nome: 'Leandro Coelho e Silva', cidade: 'Taboão da Serra', estado: 'São Paulo', ativo: true}
  ];

  constructor() { }

  ngOnInit() {
  }

}
