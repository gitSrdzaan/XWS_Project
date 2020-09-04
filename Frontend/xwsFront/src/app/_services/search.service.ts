import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import RentAdvert from '../_model/rentAdvert.model';
import { of } from 'rxjs';
import SearchInfo from '../_model/searchInfo.model';

@Injectable()
export class SearchService {
  constructor(private http: HttpClient) {}

  search(searchInfo: SearchInfo) {
    //replace this with real api
    //something like this
    //return this.http.post<any>("ADD_URL/podaci", searchInfo);

    return this.http.post<Array<RentAdvert>>(
      `http://localhost:8089/search/search/findAdvert`,
      { searchInfo }
    );

    const mocked: RentAdvert[] = [
      {
        id: 1,
        car: {
          id: 1,
          carMark: 'VW',
          carModel: 'Golf',
          carRegistration: 'reg123',
          carFuel: { id: 1, fuel: 'Diesel' },
          carClass: 'Hatchback',
          carGrade: 5,
          carMileage: 123123,
          transmission: { id: 1, transmission: 'Manual' },
          kidsSeats: 0,
        },
        advertEndDate: null,
        advertStartDate: null,
        firm: null,
        priceForRent: null,
        priceList: null,
        user: null,
      },
      {
        id: 2,
        car: {
          id: 2,
          carMark: 'BMW',
          carModel: 'X6',
          carRegistration: 'reg312',
          carFuel: { id: 1, fuel: 'Petrol' },
          carClass: 'SUV',
          carGrade: 3,
          carMileage: 1111,
          transmission: { id: 1, transmission: 'Automatic' },
          kidsSeats: 2,
        },
        advertEndDate: null,
        advertStartDate: null,
        firm: null,
        priceForRent: null,
        priceList: null,
        user: null,
      },
      {
        id: 3,
        car: {
          id: 3,
          carMark: 'Mercedes',
          carModel: 'G63',
          carRegistration: 'reg321',
          carFuel: { id: 1, fuel: 'Petrol' },
          carClass: 'SUV',
          carGrade: 4,
          carMileage: 2221,
          transmission: { id: 1, transmission: 'Automatic' },
          kidsSeats: 0,
        },
        advertEndDate: null,
        advertStartDate: null,
        firm: null,
        priceForRent: null,
        priceList: null,
        user: null,
      },
    ];
    return of(mocked);
  }
}
