import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/authentication.service';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';
import { empty } from 'rxjs';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { MyErrorStateMatcher } from '../_helpers/myErrorStateMatcher';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  registerForm: FormGroup;
  matcher = new MyErrorStateMatcher();
  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) {
    this.registerForm = new FormGroup({
      name: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),

      address: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      state: new FormControl('', Validators.required),
      phoneNumber: new FormControl(''),
      company: new FormControl(''),
    });
  }

  ngOnInit(): void {
    this.userService.getOne().subscribe((response) => {
      console.log(response);
      this.registerForm.setValue({
        name: response.name,
        surname: response.surname,
        email: response.email,
        address: response.address,
        city: response.city,
        state: response.state,
        phoneNumber: response.phoneNumber,
        company: response.company,
      });
    });
  }

  verifyToken() {
    this.authService.verify();
  }

  update() {
    const userRegisterDTO = this.registerForm.value;
    userRegisterDTO.password = userRegisterDTO.password1;
    this.userService
      .update(userRegisterDTO)
      .subscribe((response) => this.router.navigate(['/login']));
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('myCart');
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
}
