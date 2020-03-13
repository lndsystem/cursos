import { Injectable } from '@angular/core';
import { Http, Headers, URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/toPromise'

export class PessoaFiltro {
  nome: string;
  uf: string;
  pagina = 0;
  itensPorPagina = 5;
}

@Injectable()
export class PessoasService {
  pessoaUrl = 'http://localhost:8080/pessoas'

  constructor(private http: Http) { }

  pesquisar(filtro: PessoaFiltro): Promise<any> {
    const headers = new Headers();
    headers.append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    const params = new URLSearchParams();
    params.set('page', filtro.pagina.toString());
    params.set('size', filtro.itensPorPagina.toString());

    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }

    if (filtro.uf) {
      params.set('uf', filtro.uf);
    }

    return this.http.get(this.pessoaUrl, { headers: headers, search: params})
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
    const headers = new Headers();
    headers.append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return this.http.get(this.pessoaUrl, { headers: headers })
      .toPromise()
      .then(response => response.json().content);
  }
}
