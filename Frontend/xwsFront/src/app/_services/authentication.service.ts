import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {}

  login(email: string, password: string) {
    return of(new Object());
  }

  register(
    firstName: string,
    lastName: string,
    email: string,
    password1: string,
    password2: string
  ) {
    return of({
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password1,
    });
  }

  profile() {
    return of(new Object());
  }

  updateProfile(user: any) {
    console.log(user);
    return of(user);
  }

  changePassword(changePassword: any) {
    console.log(changePassword);
    return of(new Object());
  }
}
