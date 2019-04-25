import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lancamentos-pesquisa',
  templateUrl: './lancamentos-pesquisa.component.html',
  styleUrls: ['./lancamentos-pesquisa.component.css']
})
export class LancamentosPesquisaComponent{

  lancamentos: any = [
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 14.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 24.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 34.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 44.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 54.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 64.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 74.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 84.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 94.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 114.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 124.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 134.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 144.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 154.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 164.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 174.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 184.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 194.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 204.55, pessoa: 'Padaria do José' },
    { tipo: 'RECEITA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 214.55, pessoa: 'Padaria do José' },
    { tipo: 'DESPESA', descricao: 'Compra de pão', dataVencimento: '30/06/2017', dataPagamento: null, valor: 224.55, pessoa: 'Padaria do José' }
  ]

}
