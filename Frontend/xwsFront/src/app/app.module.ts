import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderCompComponent } from './header-comp/header-comp.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';
import { AdvertCompComponent } from './advert-comp/advert-comp.component';
import { RegistrationCompComponent } from './registration-comp/registration-comp.component';
import { ShoppingCartCompComponent } from './shopping-cart-comp/shopping-cart-comp.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { IndexCompComponent } from './index-comp/index-comp.component';

@NgModule({
  declarations: [AppComponent, HeaderCompComponent, LoginCompComponent, RegisterCompComponent, AdvertCompComponent, RegistrationCompComponent, ShoppingCartCompComponent, SearchComponentComponent, IndexCompComponent],
  imports: [
    BrowserModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
//export class AppBootstrapModule {}
export class AppModule {}
