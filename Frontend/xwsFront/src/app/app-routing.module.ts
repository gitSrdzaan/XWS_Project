import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponentComponent } from './search-component/search-component.component';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { ShoppingCartCompComponent } from './shopping-cart-comp/shopping-cart-comp.component';

const routes: Routes = [
  { path: 'search', component: SearchComponentComponent },
  { path: 'car/:id', component: CarDetailsComponent },
  { path: 'login', component: LoginCompComponent },
  { path: 'register', component: RegisterCompComponent },
  { path: 'cart', component: ShoppingCartCompComponent },
  { path: '', redirectTo: 'search', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
