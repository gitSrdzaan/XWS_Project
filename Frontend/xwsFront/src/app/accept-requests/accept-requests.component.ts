import { Component, OnInit } from '@angular/core';
import { RentService } from '../_services/rent.service';

@Component({
  selector: 'app-accept-requests',
  templateUrl: './accept-requests.component.html',
  styleUrls: ['./accept-requests.component.css'],
})
export class AcceptRequestsComponent implements OnInit {
  myRequests: Array<any>;
  displayedColumns: Array<string>;
  constructor(private rentService: RentService) {
    this.displayedColumns = ['id', 'carMark', 'carModel', 'cart', 'request'];
  }

  ngOnInit(): void {
    this.rentService
      .getAllRequests()
      .subscribe((response) => (this.myRequests = response));
    //this.myRequests = JSON.parse(localStorage.getItem('myRequests'));
    if (this.myRequests === null) this.myRequests = [];
    console.log(this.myRequests);
  }
  removeRequest(id) {
    console.log(id);
    this.myRequests = this.myRequests.filter((item) => item.id !== id);
    localStorage.removeItem('myRequests');
    localStorage.setItem('myRequests', JSON.stringify(this.myRequests));
  }
  //add accepting requests in these functions
  acceptRequest(item) {
    this.rentService.rent(item).subscribe((response) => {
      console.log(response);
      this.removeRequest(item.id);
    });
  }

  acceptRequestAll() {
    if (this.myRequests === null || this.myRequests.length === 0) return;
    this.rentService.rentBundle(this.myRequests).subscribe((response) => {
      console.log(response);
      this.myRequests = [];
      localStorage.removeItem('myRequests');
      localStorage.setItem('myRequests', JSON.stringify(this.myRequests));
    });
  }
}
