import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable()
export class AuthService {
  constructor(
    private http: HttpClient,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  login(loginDTO) {
    return this.http.post<any>('http://localhost:8089/auth/login', loginDTO);
  }

  register(registerUserDTO) {
    return this.http.post<any>(
      'http://localhost:8089/auth/register',
      registerUserDTO
    );
  }

  verify() {
    let token = localStorage.getItem('token');
    if (token == null) this.router.navigate(['/login']);
    this.http.get<any>(`http://localhost:8089/auth/verify/${token}`).subscribe(
      (response) => {
        if (response === true) {
          this.snackBar.open('You have valid token', '', {
            duration: 2000,
          });
        }
      },
      (error) => {
        localStorage.removeItem('token');
        this.router.navigate(['/login']);
      }
    );
  }
}
