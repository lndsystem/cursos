import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ToastyModule } from 'ng2-toasty';
import { ConfirmDialogModule } from 'primeng/components/confirmdialog/confirmdialog';
import { ConfirmationService } from 'primeng/components/common/confirmationservice';
import { JwtHelper } from 'angular2-jwt';

import { NavbarComponent } from './navbar/navbar.component';
import { ErrorHandlerService } from './error-handler.service';
import { PessoasService } from 'app/pessoas/pessoas.service';
import { LancamentoService } from 'app/lancamentos/lancamento.service';
import { CategoriaService } from 'app/categorias/categoria.service';
import { RouterModule } from '@angular/router';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada.component';
import { Title } from '@angular/platform-browser';
import { AuthService } from 'app/seguranca/auth.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,

    ToastyModule.forRoot(),
    ConfirmDialogModule,
  ],
  declarations: [NavbarComponent, PaginaNaoEncontradaComponent],
  exports: [
    NavbarComponent,
    ToastyModule,
    ConfirmDialogModule
  ],
  providers: [
    LancamentoService,
    PessoasService,
    ConfirmationService,
    CategoriaService,
    JwtHelper,
    Title,
    { provide: LOCALE_ID, useValue: 'pt-BR'},
    AuthService,

    ErrorHandlerService
  ]
})
export class CoreModule { }
