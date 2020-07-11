import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Car from '../_model/car.model';
import { of } from 'rxjs';

@Injectable()
export class CarService {
  constructor(private http: HttpClient) {}

  getById(id: number) {
    //replace this with real api
    /*
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>(`http://localhost:8080/automobil/prikaz/${id}`, {
      headers: { 'x-auth': token },
    });
    */
    const mocked: Car = {
      id: 1,
      carClass: 'SUV',
      carFuel: { id: 1, fuel: 'Diesel' },
      carGrade: 5,
      carMark: 'BMW',
      carMileage: 123,
      carModel: 'X5',
      carRegistration: 'reg345',
      kidsSeats: 0,
      transmission: { id: 1, transmission: 'Automatic' },
    };
    return of(mocked);
  }

  getAllMarks() {
    //replace this with real api
    //return this.http.get<any>(`ADD_URL/automobil/marke`);
    return of([
      'BMW',
      'Mercedes',
      'Audi',
      'Mini',
      'Opel',
      'Peugeot',
      'VW',
      'Mazda',
      'Honda',
      'Toyota',
    ]);
  }

  getAllModels() {
    //replace this with real api
    //return this.http.get<any>(`ADD_URL/automobil/modeli`);
    return of([
      'X5',
      'X6',
      'G63',
      'S600',
      '407',
      'Cooper',
      'Corolla',
      'Yaris',
      'Golf',
      'Q7',
      'A8',
    ]);
  }

  getAllCarClasses() {
    //replace this with real api
    //return this.http.get<any>(`ADD_URL/automobil/klase`);
    return of([
      'Microcar',
      'A-segment/City car',
      'Premium compact',
      'Supercar',
      'Crossover SUV',
      'SUV',
      'Executive',
    ]);
  }
  getAllCarTransmission() {
    //replace this with real api
    //return this.http.get<any>(`ADD_URL/automobil/prenos`);
    return of(['Manual', 'Automatic']);
  }

  getAllCarFuel() {
    //replace this with real api
    //return this.http.get<any>(`ADD_URL/automobil/gorivo`);
    return of(['Gasoline', 'Diesel', 'CNG', 'Hybrid', 'Electric']);
  }
}
