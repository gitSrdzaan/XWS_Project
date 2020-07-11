import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/authentication.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  constructor(
    private authService: AuthService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userService.getOne().subscribe((response) => console.log(response));
  }

  verifyToken() {
    this.authService.verify();
  }
}
