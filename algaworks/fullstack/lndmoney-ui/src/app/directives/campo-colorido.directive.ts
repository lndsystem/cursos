import { Directive, ElementRef, Renderer2, HostListener, HostBinding, Input } from '@angular/core';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';

@Directive({
  selector: '[appCampoColorido]',
  exportAs: 'campoColorido'
})
export class CampoColoridoDirective {

  constructor(/*
    private elementRef: ElementRef,
    private renderer: Renderer2*/
  ) {
    //Assim que o contrutor é chamado, ele carrega na tela (precisa do construtor ElementRef e Renderer2)
    //this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'yellow');
  }

  //@HostListener (precisa do construtor ElementRef e Renderer2)
  /*@HostListener('focus') aoGanharFoco() {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'yellow');
  }

  @HostListener('blur') aoPerderFoco() {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'transparent');
  }*/

  /*  Utilizando HostBinding exemplo 1*/
  /*@HostBinding('style.backgroundColor') corDeFundo: string;

  @HostListener('focus') aoGanharFoco() {
    this.corDeFundo =  'yellow';
  }

  @HostListener('blur') aoPerderFoco() {
    this.corDeFundo =  'transparent';
  }*/

  /*property binding (passar parametro)*/
  @Input() cor = 'gray';

  @HostBinding('style.backgroundColor') corDeFundo: string;

  @HostListener('focus') colorir() {
    this.corDeFundo =  this.cor;
  }

  @HostListener('blur') descolorir() {
    this.corDeFundo =  'transparent';
  }
}
