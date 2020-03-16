import { Injectable } from '@angular/core';
import { Http, Headers, URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/toPromise'
import { Pessoa } from 'app/core/model';
import { AuthHttp } from 'angular2-jwt';

export class PessoaFiltro {
  nome: string;
  uf: string;
  pagina = 0;
  itensPorPagina = 5;
}

@Injectable()
export class PessoasService {
  pessoaUrl = 'http://localhost:8080/pessoas'

  constructor(private http: AuthHttp) { }

  pesquisar(filtro: PessoaFiltro): Promise<any> {
    const params = new URLSearchParams();
    params.set('page', filtro.pagina.toString());
    params.set('size', filtro.itensPorPagina.toString());

    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }

    if (filtro.uf) {
      params.set('uf', filtro.uf);
    }

    return this.http.get(this.pessoaUrl, { search: params})
      .toPromise()
      .then(response => {
        const result = response.json();
        const pessoas = result.content;

        const resultado = {
          pessoas,
          total: result.totalElements
        }
        return resultado;
      });
  }

  listaTodos(): Promise<any> {
    return this.http.get(this.pessoaUrl)
      .toPromise()
      .then(response => response.json().content);
  }

  excluir(codigo: number): Promise<void> {
    return this.http.delete(`${this.pessoaUrl}/${codigo}`)
      .toPromise()
      .then(() => null);
  }

  mudarStatus(codigo: number, ativo: boolean): Promise<void> {
    return this.http.put(`${this.pessoaUrl}/${codigo}/ativo`, ativo)
      .toPromise()
      .then(() => null);
  }

  adicionar(pessoa: Pessoa): Promise<Pessoa> {
    return this.http.post(this.pessoaUrl,
      JSON.stringify(pessoa))
      .toPromise()
      .then(res => res.json());
  }

  atualizar(pessoa: Pessoa): Promise<Pessoa> {
    return this.http.put(`${this.pessoaUrl}/${pessoa.codigo}`,
      JSON.stringify(pessoa)
    ).toPromise()
    .then(pes => pes.json());
  }

  pesquisarPorId(codigo: number): Promise<Pessoa> {
    return this.http.get(`${this.pessoaUrl}/${codigo}`)
      .toPromise()
      .then(lanc => lanc.json());
  }
}
