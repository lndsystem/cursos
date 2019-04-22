import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello',
  template: `<h2>Hello {{nome}}</h2>`,
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  nome = 'Tiago';

  constructor() { }

  ngOnInit() {
  }

}
