import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LOCALE_ID, NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import localePt from "@angular/common/locales/pt";
import {registerLocaleData} from "@angular/common";

import {CurrencyMaskModule} from "ng2-currency-mask";
import {TableModule} from "primeng/components/table/table";
import {DropdownModule} from "primeng/components/dropdown/dropdown";
import {InputTextModule} from "primeng/components/inputtext/inputtext";
import {PanelModule} from "primeng/components/panel/panel";
import {ButtonModule} from "primeng/components/button/button";

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {VendasListagemComponent} from './vendas-listagem/vendas-listagem.component';
import {VendasCadastroComponent} from './vendas-cadastro/vendas-cadastro.component';

registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    VendasListagemComponent,
    VendasCadastroComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,

    CurrencyMaskModule,
    TableModule,
    DropdownModule,
    InputTextModule,
    PanelModule,
    ButtonModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pt'},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
