import { Component, ViewChild } from '@angular/core';
import { LancamentoService, LancamentoFiltro } from '../lancamento.service';
import { LazyLoadEvent } from 'primeng/components/common/lazyloadevent';
import { ToastyService } from 'ng2-toasty';
import { ConfirmationService } from 'primeng/components/common/confirmationservice';
import { ErrorHandlerService } from 'app/core/error-handler.service';

@Component({
  selector: 'app-lancamento-pesquisa',
  templateUrl: './lancamento-pesquisa.component.html',
  styleUrls: ['./lancamento-pesquisa.component.css']
})

export class LancamentoPesquisaComponent {

  lancamentos = [];
  totalRegistros = 0;
  filtro = new LancamentoFiltro();
  @ViewChild('tabela') grid;

  constructor(
    private lancamentoService: LancamentoService,
    private toasty: ToastyService,
    private confirmation: ConfirmationService,
    private error: ErrorHandlerService
  ) { }

  pesquisar(pagina = 0) {
    this.filtro.pagina = pagina;

    this.lancamentoService.pesquisar(this.filtro)
      .then(resultado => {
        this.totalRegistros = resultado.total;
        this.lancamentos = resultado.lancamentos;
      })
      .catch(erro => this.error.handle(erro));
  }

  aoMudarPagina(event: LazyLoadEvent) {
    const pagina = event.first / event.rows;
    this.pesquisar(pagina);
  }

  excluir(lancamento: any) {
    this.confirmation.confirm({
      message: 'Tem certeza que seja excluir?',
      accept: () => {
        this.lancamentoService.excluir(lancamento.codigo)
          .then(() => {
            if (this.grid.first === 0){
              this.pesquisar();
            } else {
              this.grid.first = 0;
            }
            this.toasty.success('Lançamento excluído com sucesso.')
          })
          .catch(erro => this.error.handle(erro));
      }
    });
  }
}
