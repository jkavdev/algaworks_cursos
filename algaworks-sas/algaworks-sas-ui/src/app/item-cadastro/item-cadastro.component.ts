import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-item-cadastro',
  templateUrl: './item-cadastro.component.html',
  styleUrls: ['./item-cadastro.component.css']
})
export class ItemCadastroComponent implements OnInit {

  itens = [
    { "etiqueta": "AD3415", "descricao": "Framework", dataAquisicao: new Date()},
    { "etiqueta": "AD3454", "descricao": "Mouse", dataAquisicao: new Date()}
  ];

  constructor() { }

  ngOnInit() {
  }

}
