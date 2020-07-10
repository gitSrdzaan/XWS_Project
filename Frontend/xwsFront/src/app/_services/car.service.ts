import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Car from '../_model/car.model';
import { of } from 'rxjs';

@Injectable()
export class CarService {
  constructor(private http: HttpClient) {}

  getById(id: number) {
    //replace this with real api
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
}
