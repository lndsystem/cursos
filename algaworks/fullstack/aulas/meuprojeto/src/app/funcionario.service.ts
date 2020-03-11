import { Injectable } from '@angular/core';
import { LogService } from './log.service';

@Injectable()
export class FuncionarioService {

  ultimoId = 1;
  funcionarios = [{id: 1, nome: 'João'}];
  constructor(private logService: LogService) { }

  adicionar(nome: string) {
    this.logService.log(`Adicionando ${nome}`);

    const funcionario = {
      id: ++this.ultimoId,
      nome: nome
    };

    this.funcionarios.push(funcionario);
  }

  consultar() {
    return this.funcionarios;
  }

}
/*
export class FuncionarioAbreviadoService extends FuncionarioService {
  constructor(private numeroCaracteres: number) {
    super();
  }
  adicionar(nome: string) {
    super.adicionar(nome.substr(0, this.numeroCaracteres) + '...');
  }
}
*/
