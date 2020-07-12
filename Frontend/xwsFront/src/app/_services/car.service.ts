import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CarService {
  constructor(private http: HttpClient) {}

  getById(id: number) {
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>(
      `http://localhost:8089/search/automobil/prikaz/${id}`,
      {
        headers: { 'x-auth': `Bearer ${token}` },
      }
    );
  }

  addNewCar(car) {
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    car.user = user;
    return this.http.post<any>('http://localhost:8085/car/new', car, {
      headers: { 'x-auth': `Bearer ${token}` },
    });
  }

  getAllMarks() {
    return this.http.get<any>(`http://localhost:8089/search/automobil/marke`);
  }

  getAllModels() {
    return this.http.get<any>(`http://localhost:8089/search/automobil/modeli`);
  }

  getAllCarClasses() {
    return this.http.get<any>(`http://localhost:8089/search/automobil/klase`);
  }
  getAllCarTransmission() {
    return this.http.get<any>(`http://localhost:8089/search/automobil/prenos`);
  }

  getAllCarFuel() {
    return this.http.get<any>(`http://localhost:8089/search/automobil/gorivo`);
  }
}
