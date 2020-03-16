import { Component, OnInit, ViewChild } from '@angular/core';
import { PessoaFiltro, PessoasService } from '../pessoas.service';
import { LazyLoadEvent } from 'primeng/components/common/lazyloadevent';
import { ToastyService } from 'ng2-toasty';
import { ConfirmationService } from 'primeng/components/common/confirmationservice';
import { ErrorHandlerService } from 'app/core/error-handler.service';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-pessoas-pesquisa',
  templateUrl: './pessoas-pesquisa.component.html',
  styleUrls: ['./pessoas-pesquisa.component.css']
})
export class PessoasPesquisaComponent implements OnInit {

  pessoas = [];
  totalRegistros = 0;
  filtro = new PessoaFiltro();
  @ViewChild('tabela') grid: any;

  constructor(
    private pessoasService: PessoasService,
    private toasty: ToastyService,
    private confirmation: ConfirmationService,
    private error: ErrorHandlerService,
    private title: Title
    ) { }

  ngOnInit() {
    this.title.setTitle('Pesquisa de pessoas')
  }

  pesquisar(pagina = 0) {
    this.filtro.pagina = pagina;

    this.pessoasService.pesquisar(this.filtro)
      .then(resultado => {
        this.totalRegistros = resultado.total;
        this.pessoas = resultado.pessoas;
      });
  }

  aoMudarPagina(event: LazyLoadEvent) {
    const pagina = event.first / event.rows;
    this.pesquisar(pagina);
  }

  excluir(pessoa: any) {
    this.confirmation.confirm({
      message: 'Tem certeza que seja excluir?',
      accept: () => {
        this.pessoasService.excluir(pessoa.codigo)
          .then(() => {
            if (this.grid.first === 0) {
              this.pesquisar();
            } else {
              this.grid.first = 0;
            }
            this.toasty.success('Pessoa excluída com sucesso.');
          })
          .catch(erro => this.error.handle(erro));
      }
    });
  }

  mudarStatus(pessoa: any) {
    const novoStatus = !pessoa.ativo;

    this.pessoasService.mudarStatus(pessoa.codigo, !pessoa.ativo)
      .then(() => {
        const acao = novoStatus ? 'ativada' : 'desativada';

        pessoa.ativo = novoStatus;
        this.toasty.success(`Pessoa ${acao} com sucesso!`);
      })
      .catch(erro => this.error.handle(erro));
  }
}
