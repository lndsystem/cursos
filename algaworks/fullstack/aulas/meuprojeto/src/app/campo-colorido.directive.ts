import { Directive, /* Modo 1 - ElementRef, Renderer2,*/ HostListener, HostBinding, Input } from '@angular/core';

@Directive({
  selector: '[appCampoColorido]', // se colocar input no nome, passa aplicar em todos os inputs
  exportAs: 'campoColorido'
})
export class CampoColoridoDirective {
  // Modo 3
  @Input() cor = 'gray';

  // Modo 2
  @HostBinding('style.backgroundColor') corDeFundo: string;

  constructor(/* Modo 1
    private elementRef: ElementRef,
    private renderer: Renderer2
  */) {}

  @HostListener('focus') onFocus() {
    // modo 1
    /*this.renderer.setStyle(this.elementRef.nativeElement,
      'background-color', 'yellow');*/

    // modo 2
    this.corDeFundo = 'yellow';

    // modo 3
    this.corDeFundo = this.cor;
  }

  @HostListener('blur') ofFocus() {
    // modo 1
    /*this.renderer.setStyle(this.elementRef.nativeElement,
      'background-color', 'transparent');*/

    // modo 2
    this.corDeFundo = 'transparent';
  }
}
