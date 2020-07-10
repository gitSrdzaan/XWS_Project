import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { MyErrorStateMatcher } from '../_helpers/myErrorStateMatcher';

@Component({
  selector: 'app-register-comp',
  templateUrl: './register-comp.component.html',
  styleUrls: ['./register-comp.component.css'],
})
export class RegisterCompComponent implements OnInit {
  registerForm: FormGroup;
  matcher = new MyErrorStateMatcher();

  constructor() {
    this.registerForm = new FormGroup(
      {
        firstName: new FormControl('', Validators.required),
        lastName: new FormControl('', Validators.required),
        email: new FormControl('', [Validators.required, Validators.email]),
        password1: new FormControl('', [
          Validators.required,
          Validators.minLength(6),
        ]),
        password2: new FormControl('', [
          Validators.required,
          Validators.minLength(6),
        ]),
      },
      { validators: this.checkPasswords }
    );
  }

  ngOnInit(): void {}

  register() {
    const formValue = this.registerForm.value;
    console.log(formValue);
  }

  checkPasswords(group: FormGroup) {
    let pass = group.controls.password1.value;
    let confirmPass = group.controls.password2.value;

    return pass === confirmPass ? null : { notSame: true };
  }
}
