import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  length = 100;
  pageSize = 10;
  pageIndex: number = 0;

  displayedColumns: Array<string>;
  userList = new MatTableDataSource<any>();

  constructor(private userService: UserService) {
    this.displayedColumns = [
      'id',
      'email',
      'name',
      'surname',
      'address',
      'city',
      'state',
      'enabled',
      'changeStatus',
      'delete',
    ];
  }

  ngOnInit(): void {
    this.userService
      .getAll(this.pageIndex, null)
      .subscribe(
        (response) =>
          (this.userList = new MatTableDataSource<any>(response.content))
      );
  }

  getServerData(event?: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.userService
      .getAll(this.pageIndex, null)
      .subscribe(
        (response) =>
          (this.userList = new MatTableDataSource<any>(response.content))
      );
  }

  activateOrDeactivate(id) {
    this.userService.activateOrDeativate(id).subscribe((response) => {
      this.userList.data.forEach((element) => {
        if (element.id === id) element.enabled = !element.enabled;
      });
    });
  }

  delete(id) {
    console.log(id);
    this.userService.delete(id).subscribe((response) => {
      this.userList.data = this.userList.data.filter((item) => item.id != id);
    });
  }
}
