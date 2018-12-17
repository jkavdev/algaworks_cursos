import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LOCALE_ID, NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import localePt from "@angular/common/locales/pt";
import {registerLocaleData} from "@angular/common";

import {TableModule} from "primeng/components/table/table";

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {VendasListagemComponent} from './vendas-listagem/vendas-listagem.component';

registerLocaleData(localePt);

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
  providers: [
    {provide: LOCALE_ID, useValue: 'pt'},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
