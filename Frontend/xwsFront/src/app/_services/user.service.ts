import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { of } from 'rxjs';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserDTO } from '../_model/userDTO.model';

@Injectable()
export class UserService {
  constructor(
    private http: HttpClient,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  getOne() {
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>(`http://localhost:8080/user/${user.id}`, {
      headers: { 'x-auth': token },
    });
  }

  getAll(pageIndex: number, sort: string) {
    /*
    let params = new HttpParams()
      .set('page', pageIndex.toString())
      .set('sort', sort);

    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>('http://localhost:8080/user', {
      headers: { 'x-auth': token },
      params: params,
    });
    */
    let mockUser1: UserDTO = {
      id: 1,
      password: null,
      email: 'email@gmail.com',
      name: 'name1',
      surname: 'surname1',
      address: 'address1',
      city: 'city1',
      state: 'state1',
      phoneNumber: '123321',
      enabled: false,
      company: '123',
      roles: new Set(),
    };
    let mockUser2: UserDTO = {
      id: 2,
      password: null,
      email: 'email2@gmail.com',
      name: 'name2',
      surname: 'surname2',
      address: 'address2',
      city: 'city2',
      state: 'state2',
      phoneNumber: '1233221',
      enabled: true,
      company: '12322',
      roles: new Set(),
    };

    let mockResponse = {
      content: [mockUser1, mockUser2],
      pageNo: 0,
      totalPages: 10,
    };
    return of(mockResponse);
  }

  activateOrDeativate(id) {
    /*
    let token = localStorage.getItem('token');
    if (token === null) return;
    return this.http.patch(`http://localhost:8080/user/${id}`, {
      headers: { 'x-auth': token },
    });
    */
    return of(true);
  }

  delete(id) {
    /*
    let token = localStorage.getItem('token');
    if (token === null) return;
    return this.http.delete(`http://localhost:8080/user/${id}`, {
      headers: { 'x-auth': token },
    });
    */
    return of(true);
  }
}
