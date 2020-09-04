import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CarService {
  constructor(private http: HttpClient) {}

  getById(id: number) {
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>(`http://localhost:8089/search/car/getCar/${id}`, {
      headers: { 'x-auth': `Bearer ${token}` },
    });
  }

  addNewCar(car) {
    return this.http.post<any>(`http://localhost:8089/advert/car/new`, car);
    /*let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    car.user = user;
    return this.http.post<any>('http://localhost:8089/advert/car/new', car, {
      headers: { 'x-auth': `Bearer ${token}` },
    });*/
  }

  getAllMarks() {
    return this.http.get<any>(`http://localhost:8089/search/car/marks`);
  }

  getAllModels() {
    return this.http.get<any>(`http://localhost:8089/search/car/models`);
  }

  getAllCarClasses() {
    return this.http.get<any>(`http://localhost:8089/search/car/classes`);
  }
  getAllCarTransmission() {
    return this.http.get<any>(`http://localhost:8089/search/car/transmissions`);
  }

  getAllCarFuel() {
    return this.http.get<any>(`http://localhost:8089/search/car/fuels`);
  }
  getAllCarRegs() {
    return this.http.get<any>(`http://localhost:8089/search/car/registration`);
  }

  getAllCars() {
    return this.http.get<any>(`http://localhost:8080/car/all`);
  }
}
