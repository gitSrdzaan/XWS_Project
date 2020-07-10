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
}
