import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { BemVindoComponent } from './bem-vindo/bem-vindo.component';
import { FuncionarioCardComponent } from './funcionario/funcionario-card/funcionario-card.component';
import { FuncionarioFormComponent } from './funcionario/funcionario-form/funcionario-form.component';
import { CampoColoridoDirective } from './campo-colorido.directive';
import { ExemploPipeComponent } from './exemplo-pipe/exemplo-pipe.component';
import { FormulariosComponent } from './formularios/formularios.component';
import { NavegacaoModule } from './navegacao/navegacao.module';
import { LogService } from './log.service';
import { FuncionarioService } from './funcionario.service';
import { FuncionarioModule } from './funcionario/funcionario.module';
import { CidadesComponent } from './cidades/cidades.component';
import { CidadeService } from './cidade.service';
/*
const criarFuncionarioService = () => {
  return new FuncionarioAbreviadoService(2);
}*/

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    BemVindoComponent,
    CampoColoridoDirective,
    ExemploPipeComponent,
    FormulariosComponent,
    CidadesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NavegacaoModule,
    FuncionarioModule,
    HttpModule
  ],
  providers: [
    // FuncionarioService, // suggar - atalho
    // { provide: FuncionarioService, useClass: FuncionarioAbreviadoService } // modo literal
    // { provide: FuncionarioService, useFactory: criarFuncionarioService } // modo literal usando fabrica
    LogService,
    { provide: 'LogPrefixo', useValue: 'LOG'},
    CidadeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
