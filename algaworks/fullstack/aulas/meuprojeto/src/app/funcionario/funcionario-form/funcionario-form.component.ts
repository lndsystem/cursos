import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FuncionarioService } from '../../funcionario.service';
import { NavegacaoModule } from '../../navegacao/navegacao.module';
import { LogService } from 'app/log.service';

@Component({
  selector: 'app-funcionario-form',
  templateUrl: './funcionario-form.component.html',
  styleUrls: ['./funcionario-form.component.css']
})
export class FuncionarioFormComponent implements OnInit {

  constructor(
   private funcionarioService: FuncionarioService,
  ) { }

  ngOnInit() {
  }

  adicionar(nome: string) {
    this.funcionarioService.adicionar(nome);
  }

}
