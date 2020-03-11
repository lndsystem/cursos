import { Component, OnInit, NgModule } from '@angular/core';

@Component({
  selector: 'app-exemplo-pipe',
  templateUrl: './exemplo-pipe.component.html',
  styleUrls: ['./exemplo-pipe.component.css']
})
export class ExemploPipeComponent implements OnInit {

  nome = 'Leandro Coelho';
  dataAniversario = new Date(1990, 3, 19);
  preco = 12855.32;
  troco = 0.57392;


  constructor() { }

  ngOnInit() {
  }

}
