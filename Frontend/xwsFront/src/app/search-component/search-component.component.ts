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
      country: [''],
      city: [''],
      takingDate: [],
      returningDate: [],
    });
  }

  ngOnInit(): void {}

  submitForm() {
    let searchObject = JSON.parse(JSON.stringify(this.searchForm.value));
    let takingDateTime = searchObject.takingDate
      ? new Date(searchObject.takingDate)
      : null;
    let returningDateTime = searchObject.returningDate
      ? new Date(searchObject.returningDate)
      : null;
    if (takingDateTime) {
      takingDateTime.setSeconds(0);
      searchObject.takingDate = takingDateTime.toISOString();
    }
    if (returningDateTime) {
      returningDateTime.setSeconds(0);
      searchObject.returningDate = returningDateTime.toISOString();
    }

    console.log(searchObject);

    this.searchService
      .searchLocation(
        searchObject.country,
        searchObject.city,
        searchObject.takingDate,
        searchObject.returningDate
      )
      .subscribe((response) => {
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
    this.router.navigate(['/advert', id]);
  }
}
