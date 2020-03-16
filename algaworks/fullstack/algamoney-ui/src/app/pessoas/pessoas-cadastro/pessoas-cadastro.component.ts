import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { PessoasService } from '../pessoas.service';
import { ToastyService } from 'ng2-toasty';
import { Pessoa } from 'app/core/model';
import { ErrorHandlerService } from '../../core/error-handler.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-pessoas-cadastro',
  templateUrl: './pessoas-cadastro.component.html',
  styleUrls: ['./pessoas-cadastro.component.css']
})
export class PessoasCadastroComponent implements OnInit {

  pessoa = new Pessoa();
  constructor(
    private pessoaService: PessoasService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService,
    private route: ActivatedRoute,
    private router: Router,
    private title: Title
  ) { }

  ngOnInit() {
    const codigo = this.route.snapshot.params['codigo'];

    this.title.setTitle('Nova pessoa')
    if (codigo) {
      this.carregarPessoa(codigo);
    }
  }

  carregarPessoa(codigo: number) {
    this.pessoaService.pesquisarPorId(codigo)
      .then(pessoa => {
        this.pessoa = pessoa;
        this.atualizarTituloPessoa();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  atualizarTituloPessoa() {
    this.title.setTitle(`Edição de pessoa: ${this.pessoa.nome}`)
  }

  salvar(form: FormControl) {
    console.log('entrou')
    this.adicionarAtualizarPessoa(form);
  }

  adicionarAtualizarPessoa(form: FormControl) {
    if (this.pessoa.codigo) {
      this.pessoaService.atualizar(this.pessoa)
      .then(pes => {
        this.pessoa = pes;
        this.atualizarTituloPessoa();
        this.toasty.success('Pessoa atualizada com sucesso.')
      })
      .catch(erro => this.errorHandler.handle(erro));
    } else {
      this.pessoaService.adicionar(this.pessoa)
      .then(() => {
        this.toasty.success('Pessoa salva com sucesso.');
        form.reset();
        this.pessoa = new Pessoa();
      })
      .catch(erro => this.errorHandler.handle(erro));
    }
  }

  atualiazarPessoa(form: FormControl) {
    this.adicionarAtualizarPessoa(form);
  }

  novo(form: FormControl) {
    form.reset();

    setTimeout(function() {
      this.pessoa = new Pessoa();
    }.bind(this), 1);
    this.router.navigate(['/pessoas/novo']);
  }
}
