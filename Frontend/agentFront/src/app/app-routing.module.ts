import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponentComponent } from './search-component/search-component.component';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { ShoppingCartCompComponent } from './shopping-cart-comp/shopping-cart-comp.component';
import { CarsComponent } from './cars/cars.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UsersComponent } from './users/users.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { AdvertCompComponent } from './advert-comp/advert-comp.component';
import { CreateRentAdvertComponent } from './create-rent-advert/create-rent-advert.component';
import { CreatePricelistComponent } from './create-pricelist/create-pricelist.component';
import { AcceptRequestsComponent } from './accept-requests/accept-requests.component';

const routes: Routes = [
  { path: 'search', component: SearchComponentComponent },
  { path: 'car/:id', component: CarDetailsComponent },
  { path: 'cars', component: CarsComponent },
  { path: 'login', component: LoginCompComponent },
  { path: 'register', component: RegisterCompComponent },
  { path: 'cart', component: ShoppingCartCompComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'users', component: UsersComponent },
  { path: 'new-car', component: CreateCarComponent },
  { path: 'rentAdvert', component: AdvertCompComponent },
  { path: 'createRentAdvert', component: CreateRentAdvertComponent },
  { path: 'createPriceList', component: CreatePricelistComponent },
  { path: 'acceptRequests', component: AcceptRequestsComponent },

  { path: '', redirectTo: 'search', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
