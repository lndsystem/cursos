import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testes',
  templateUrl: './testes.component.html',
  styleUrls: ['./testes.component.css']
})
export class TestesComponent implements OnInit {

  nome = 'Leandro Coelho';
  dataAniversario = new Date();
  valor1 = 12855.32;
  valor2 = 0.57392;


  constructor() { }

  ngOnInit() {
  }

}
