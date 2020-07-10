import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchComponentComponent } from './search-component/search-component.component';
import { AdvertCompComponent } from './advert-comp/advert-comp.component';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';

const routes: Routes = [
  { path: 'search', component: SearchComponentComponent },
  { path: 'advert/:id', component: AdvertCompComponent },
  { path: 'login', component: LoginCompComponent },
  { path: 'register', component: RegisterCompComponent },
  { path: '', redirectTo: 'search', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
