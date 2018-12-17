import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import {TableModule} from "primeng/components/table/table";

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {VendasListagemComponent} from './vendas-listagem/vendas-listagem.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    VendasListagemComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
