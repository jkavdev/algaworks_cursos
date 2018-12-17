import {Component, OnInit} from '@angular/core';

import {VendasService} from "../vendas/vendas.service";

@Component({
  selector: 'app-vendas-cadastro',
  templateUrl: './vendas-cadastro.component.html',
  styleUrls: ['./vendas-cadastro.component.css']
})
export class VendasCadastroComponent implements OnInit {

  clientes: Array<any>;

  constructor(private vendaService: VendasService) {
  }

  ngOnInit() {
    this.vendaService.listarClientes().subscribe(response => {
      this.clientes = response
      console.log(response)
    } );
  }

}
