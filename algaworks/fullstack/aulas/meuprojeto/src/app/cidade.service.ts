import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise'

@Injectable()
export class CidadeService {
  private urls = 'http://localhost:3000/cidades';
  constructor(private http: Http) { }

  consultar(): Promise<any> {
    return this.http.get(this.urls)
      .toPromise()
      .then(response => response.json());
  }

  adicionar(cidade: any): Promise<any> {
    return this.http.post(this.urls, cidade)
      .toPromise()
      .then(response => response.json());
  }

  excluir(id: number): Promise<void> {
    return this.http.delete(`${this.urls}/${id}`)
      .toPromise()
      .then(() => null);
  }

  atualizar(cidade: any): Promise<any> {
    return this.http.put(`${this.urls}/${cidade.id}`, cidade)
      .toPromise()
      .then(response => response.json())
      .catch(error => {
        return Promise.reject(`Erro ao alterar cidade ${cidade.id}`);
      });
  }

}
