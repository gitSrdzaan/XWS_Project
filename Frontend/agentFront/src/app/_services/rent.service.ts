import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Car from '../_model/car.model';
import { of } from 'rxjs';

@Injectable()
export class RentService {
  constructor(private http: HttpClient) {}

  rent(item: any) {
    //replace this with real api
    return of(new Object());
  }

  rentBundle(items) {
    //replace this with real api
    return of(new Object());
  }

  addNewPriceList(priceList) {
    return this.http.post<any>(
      `http://localhost:8080/pricelist/new`,
      priceList
    );
    /*let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    priceList.user = user;
    return this.http.post<any>(
      'http://localhost:8080/pricelist/new',
      priceList,
      {
        headers: { 'x-auth': `Bearer ${token}` },
      }
    );*/
  }

  addNewRentAdvert(rentAdvert) {
    return this.http.post<any>(`http://localhost:8080/advert/new`, rentAdvert);
    /*let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    rentAdvert.user = user;
    return this.http.post<any>('http://localhost:8080/advert/new', rentAdvert, {
      headers: { 'x-auth': `Bearer ${token}` },
    });*/
  }
  getAllAds() {
    return this.http.get<any>(`http://localhost:8080/advert/getAll`);
  }
  getAllPriceList() {
    return this.http.get<any>(`http://localhost:8080/pricelist/findAll`);
  }
}
