import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

import { ToastyService } from 'ng2-toasty';

import { ErrorHandlerService } from 'app/core/error-handler.service';
import { CategoriaService } from 'app/categorias/categoria.service';
import { PessoasService } from 'app/pessoas/pessoas.service';
import { LancamentoService } from '../lancamento.service';
import { Lancamento } from '../../core/model';

@Component({
  selector: 'app-lancamento-cadastro',
  templateUrl: './lancamento-cadastro.component.html',
  styleUrls: ['./lancamento-cadastro.component.css']
})
export class LancamentoCadastroComponent implements OnInit {

  tipos = [
    { label: 'Receita', value: 'RECEITA' },
    { label: 'Despesa', value: 'DESPESA' }
  ];

  categorias = [];
  pessoas = [];
  lancamento = new Lancamento();

  constructor(
    private categoriaService: CategoriaService,
    private errorHandler: ErrorHandlerService,
    private pessoasService: PessoasService,
    private lancamentoService: LancamentoService,
    private toasty: ToastyService,
    private route: ActivatedRoute,
    private router: Router,
    private title: Title
  ) { }

  ngOnInit() {
    const codigo = this.route.snapshot.params['codigo'];

    this.title.setTitle('Novo lançamento');
    if (codigo) {
      this.carregarLancamento(codigo);
    }

    this.carregarCategorias();
    this.carregarPessoas();
  }

  carregarCategorias() {
    this.categoriaService.listarTodas().then(categorias => {
      this.categorias = categorias.map(c => {
        return ({label: c.nome, value: c.codigo});
      });
    })
    .catch(error => this.errorHandler.handle(error));
  }

  carregarPessoas() {
    this.pessoasService.listaTodos()
      .then(pessoas => {
        this.pessoas = pessoas.map(p => {
          return ({label: p.nome, value: p.codigo})
        });
      })
      .catch(error => this.errorHandler.handle(error));
  }

  salvar(form: FormControl) {
    if (this.editando) {
      this.atualizarLancamento(form);
    } else {
      this.adicionarLancamento(form);
    }
  }

  adicionarLancamento (form: FormControl) {
    this.lancamentoService.adicionar(this.lancamento)
      .then(lancamento => {
        this.toasty.success('Lançamento adicionado com sucesso!');
        this.router.navigate(['/lancamentos', lancamento.codigo]);
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  atualizarLancamento (form: FormControl) {
    this.lancamentoService.atualizar(this.lancamento)
    .then(lancamento => {
      this.lancamento = lancamento;
      this.atualizarTituloEdicao();
      this.toasty.success('Lançamento alterado com sucesso!');
    })
    .catch(erro => this.errorHandler.handle(erro));
  }

  carregarLancamento(codigo: number) {
    this.lancamentoService.buscarPorCodigo(codigo)
      .then(lancamento => {
        this.lancamento = lancamento
        this.atualizarTituloEdicao();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  novo(form: FormControl) {
    form.reset();

    setTimeout(function() {
      this.lancamento = new Lancamento();
    }.bind(this), 1);
    this.router.navigate(['/lancamentos/novo']);
  }

  get editando() {
    return Boolean(this.lancamento.codigo);
  }

  atualizarTituloEdicao() {
    this.title.setTitle(`Edição de lançamento: ${this.lancamento.descricao}`);
  }

}
