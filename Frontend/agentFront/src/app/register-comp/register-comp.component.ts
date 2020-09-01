import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { MyErrorStateMatcher } from '../_helpers/myErrorStateMatcher';
import { AuthService } from '../_services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-comp',
  templateUrl: './register-comp.component.html',
  styleUrls: ['./register-comp.component.css'],
})
export class RegisterCompComponent implements OnInit {
  registerForm: FormGroup;
  matcher = new MyErrorStateMatcher();

  constructor(private authService: AuthService, private router: Router) {
    this.registerForm = new FormGroup(
      {
        name: new FormControl('', Validators.required),
        surname: new FormControl('', Validators.required),
        email: new FormControl('', [Validators.required, Validators.email]),
        password1: new FormControl('', [
          Validators.required,
          Validators.minLength(6),
        ]),
        password2: new FormControl('', [
          Validators.required,
          Validators.minLength(6),
        ]),
        address: new FormControl('', Validators.required),
        city: new FormControl('', Validators.required),
        state: new FormControl('', Validators.required),
        phoneNumber: new FormControl(''),
        company: new FormControl(''),
      },
      { validators: this.checkPasswords }
    );
  }

  ngOnInit(): void {}

  register() {
    const userRegisterDTO = this.registerForm.value;
    console.log(userRegisterDTO);
    userRegisterDTO.password = userRegisterDTO.password1;
    this.authService
      .register(userRegisterDTO)
      .subscribe((response) => this.router.navigate(['/login']));
  }

  checkPasswords(group: FormGroup) {
    let pass = group.controls.password1.value;
    let confirmPass = group.controls.password2.value;

    return pass === confirmPass ? null : { notSame: true };
  }
}
