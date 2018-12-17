import {Component, OnInit} from '@angular/core';

import {VendasService} from "../vendas/vendas.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-vendas-cadastro',
  templateUrl: './vendas-cadastro.component.html',
  styleUrls: ['./vendas-cadastro.component.css']
})
export class VendasCadastroComponent implements OnInit {

  clientes: Array<any>;
  produtos: Array<any>;
  venda: any;
  item: any;

  constructor(private vendaService: VendasService) {
  }

  ngOnInit() {
    this.vendaService.listarClientes().subscribe(response => this.clientes = response);
    this.vendaService.listarProdutos().subscribe(response => this.produtos = response);

    this.novaVenda();
  }

  novaVenda() {
    this.venda = {itens: [], frete: 0.0, total: 0.0};
    this.item = {};
  }

  incluirItem() {
    this.item.total = this.item.produto.valor * this.item.quantidade;

    this.venda.itens.push(this.item);
    this.item = {};
    this.calcularTotal();
  }

  calcularTotal() {
    const totalItens = this.venda.itens
      .map(i => (i.produto.valor * i.quantidade))
      .reduce((total, v) => total + v, 0);

    this.venda.total = totalItens + this.venda.frete;
  }

  adicionar(form: FormGroup) {
    this.vendaService.adicionar(this.venda).subscribe(response => {
      form.reset();

      this.novaVenda();
    })
  }

}
