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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { SearchService } from './_services/search.service';
import { CarService } from './_services/car.service';
import { AuthService } from './_services/authentication.service';
import { RentService } from './_services/rent.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatSortModule } from '@angular/material/sort';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatChipsModule } from '@angular/material/chips';

import {
  NgxMatDatetimePickerModule,
  NgxMatTimepickerModule,
  NgxMatNativeDateModule,
} from '@angular-material-components/datetime-picker';
import { CarDetailsComponent } from './car-details/car-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderCompComponent,
    LoginCompComponent,
    RegisterCompComponent,
    AdvertCompComponent,
    RegistrationCompComponent,
    ShoppingCartCompComponent,
    SearchComponentComponent,
    IndexCompComponent,
    CarDetailsComponent,
  ],
  imports: [
    BrowserModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgxMatDatetimePickerModule,
    NgxMatTimepickerModule,
    NgxMatNativeDateModule,
    MatCardModule,
    MatTableModule,
    HttpClientModule,
    MatSortModule,
    MatToolbarModule,
    MatChipsModule,
  ],
  providers: [
    SearchService,
    CarService,
    AuthService,
    RentService,
    { provide: MAT_DATE_LOCALE, useValue: 'en-US' },
  ],
  bootstrap: [AppComponent],
})
//export class AppBootstrapModule {}
export class AppModule {}
