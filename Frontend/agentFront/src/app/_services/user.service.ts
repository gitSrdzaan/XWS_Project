import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { of, throwError, empty } from 'rxjs';
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
    if (user === null) {
      return;
    }
    return this.http.get<any>(`http://localhost:8082/user/${user.id}`, {
      headers: { 'x-auth': `Bearer ${token}` },
    });
  }

  getAll(pageIndex: number, sort: string) {
    let user = JSON.parse(localStorage.getItem('user'));
    let token = localStorage.getItem('token');
    if (user === null) return;
    return this.http.get<any>('http://localhost:8082/user', {
      headers: { 'x-auth': `Bearer ${token}` },
    });
  }

  activateOrDeativate(id) {
    let token = localStorage.getItem('token');
    if (token === null) return;
    return this.http.patch(`http://localhost:8082/user/${id}`, {
      headers: { 'x-auth': `Bearer ${token}` },
    });

    return of(true);
  }

  delete(id) {
    let token = localStorage.getItem('token');
    if (token === null) return;
    return this.http.delete(`http://localhost:8082/user/${id}`, {
      headers: { 'x-auth': `Bearer ${token}` },
    });
  }
  update(userDTO) {
    let token = localStorage.getItem('token');
    let user = JSON.parse(localStorage.getItem('user'));
    userDTO.id = user.id;
    return this.http.put<any>(
      `http://localhost:8082/user/${user.id}`,
      userDTO,
      {
        headers: { 'x-auth': `Bearer ${token}` },
      }
    );
  }
}
