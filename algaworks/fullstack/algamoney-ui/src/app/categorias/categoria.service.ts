import { Injectable } from '@angular/core';
import { Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise'
import { AuthHttp } from 'angular2-jwt';

@Injectable()
export class CategoriaService {
  catetoriaUrl = 'http://localhost:8080/categorias'
  constructor(private http: AuthHttp) { }


  listarTodas(): Promise<any> {
    return this.http.get(this.catetoriaUrl)
      .toPromise()
      .then(response => response.json());
  }
}
