import {Component, OnInit} from '@angular/core';

import {VendasService} from "../vendas/vendas.service";

@Component({
  selector: 'app-vendas-cadastro',
  templateUrl: './vendas-cadastro.component.html',
  styleUrls: ['./vendas-cadastro.component.css']
})
export class VendasCadastroComponent implements OnInit {

  clientes: Array<any>;
  produtos: Array<any>;
  venda: any = {itens: []};
  item: any = {};

  constructor(private vendaService: VendasService) {
  }

  ngOnInit() {
    this.vendaService.listarClientes().subscribe(response => this.clientes = response);
    this.vendaService.listarProdutos().subscribe(response => this.produtos = response);
  }

  incluirItem() {
    this.item.total = this.item.produto.valor * this.item.quantidade;

    this.venda.itens.push(this.item);
    this.item = {};
  }

}
