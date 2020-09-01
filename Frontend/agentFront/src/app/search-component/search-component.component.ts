import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import RentAdvert from '../_model/rentAdvert.model';
import { SearchService } from '../_services/search.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  styleUrls: ['./search-component.component.css'],
})
export class SearchComponentComponent implements OnInit {
  searchForm: FormGroup;
  displayedColumns: Array<string>;
  advertList = new MatTableDataSource<RentAdvert>();
  s = 1;

  constructor(
    private formBuilder: FormBuilder,
    private searchService: SearchService,
    private router: Router
  ) {
    this.searchForm = this.formBuilder.group({
      country: [null],
      city: [null],
      startDate: [],
      endDate: [],
      carMark: [null],
      carModel: [null],
      carClass: [null],
      transmission: [null],
      carFuel: [null],
      carMileage: [null],
      kidsSeats: [null],
      intendingMileage: [null],
    });
  }

  ngOnInit(): void {}

  submitForm() {
    let searchObject = this.searchForm.value;
    if (searchObject.startDate)
      searchObject.startDate = formatDate(searchObject.startDate);

    if (searchObject.endDate)
      searchObject.endDate = formatDate(searchObject.endDate);

    console.log(searchObject);
    this.searchService.search(searchObject).subscribe((response) => {
      this.advertList = new MatTableDataSource<RentAdvert>(response);
    });
    this.displayedColumns = [
      'id',
      'carMark',
      'carModel',
      'carGrade',
      'fuel',
      'transmission',
      'class',
      'mileage',
      'kids',
      'details',
      'cart',
    ];
  }
  sortGrade() {
    let sorted = this.advertList.data.sort(
      (a, b) => this.s * (b.car.carGrade - a.car.carGrade)
    );
    this.s = -this.s;
    this.advertList.data = sorted;
  }
  sortMileage() {
    let sorted = this.advertList.data.sort(
      (a, b) => this.s * (b.car.carMileage - a.car.carMileage)
    );
    this.s = -this.s;
    this.advertList.data = sorted;
  }

  details(id) {
    this.router.navigate(['/car', id]);
  }

  addToCart(advert) {
    console.log(advert);
    let myCart = JSON.parse(localStorage.getItem('myCart'));
    if (myCart === null) myCart = [];
    if (!myCart.some((item) => item.id === advert.id)) {
      myCart.push(advert);
      localStorage.setItem('myCart', JSON.stringify(myCart));
    }
  }
}

function formatDate(date) {
  var d = new Date(date),
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear();

  if (month.length < 2) month = '0' + month;
  if (day.length < 2) day = '0' + day;

  return [day, month, year].join('-');
}
