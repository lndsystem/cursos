import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from './funcionario.service';
import { CidadesComponent } from './cidades/cidades.component';
import { CidadeService } from './cidade.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  cidades = [];

  constructor(private cidadeService: CidadeService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.cidadeService.consultar()
      .then(cidades => this.cidades = cidades);
  }

  adicionar(nome: string) {
    this.cidadeService.adicionar({nome: nome})
      .then(cidade => {
        alert(`Cidade ${cidade.nome} adicionada com código ${cidade.codigo}!`);
        this.consultar();
      });

  }

  excluir(id: number) {
    this.cidadeService.excluir(id)
      .then(() => {
        alert('Cidade excluída com sucesso!');
        this.consultar();
      });
  }

  atualizar(cidade: any) {
    this.cidadeService.atualizar(cidade)
      .then(() => {
        alert('Cidade alterada com sucesso!')
      })
      .catch(erro => {
        alert(erro);
      });
  }
}
