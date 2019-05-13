import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { TableModule} from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { AppComponent } from './app.component';
import { TooltipModule } from "primeng/components/tooltip/tooltip";
import { LancamentosPesquisaComponent } from './lancamentos-pesquisa/lancamentos-pesquisa.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PessoalPesquisaComponent } from './pessoal-pesquisa/pessoal-pesquisa.component';
import { CampoColoridoDirective } from './directives/campo-colorido.directive';

@NgModule({
  declarations: [
    AppComponent,
    LancamentosPesquisaComponent,
    NavbarComponent,
    PessoalPesquisaComponent,
    CampoColoridoDirective
  ],
  imports: [
    BrowserModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
