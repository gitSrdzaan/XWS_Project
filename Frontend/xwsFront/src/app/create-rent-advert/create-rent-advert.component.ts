import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import Car from '../_model/car.model';
import { CarService } from '../_services/car.service';
import { SearchService } from '../_services/search.service';

@Component({
  selector: 'app-create-rent-advert',
  templateUrl: './create-rent-advert.component.html',
  styleUrls: ['./create-rent-advert.component.css'],
})
export class CreateRentAdvertComponent implements OnInit {
  newRentAdvertForm: FormGroup;
  cars: Array<Car>;
  carRegs: Array<String>;

  constructor(
    private formBuilder: FormBuilder,
    private carService: CarService
  ) {
    this.newRentAdvertForm = this.formBuilder.group({
      rentAdvertId: [null],
      car: [null],
      price: [null],
      firmName: [null],
      userName: [null],
      startDate: [null],
      endDate: [null],
    });
  }

  ngOnInit(): void {
    this.carService
      .getAllCarRegs()
      .subscribe((response) => (this.carRegs = response));
    this.carService
      .getAllCars()
      .subscribe((response) => (this.cars = response));
  }
  submitForm() {
    let rentAdvert = this.newRentAdvertForm.value;
    let rentAdvertDTO = {
      rentAdvertId: rentAdvert.rentAdvertId,
      car: rentAdvert.car,
      price: rentAdvert.price,
      firmName: rentAdvert.firmName,
      userName: rentAdvert.userName,
      startDate: rentAdvert.startDate,
      endDate: rentAdvert.endDate,
    };
    //this.SearchService
    //.addNewRentAdvert(rentAdvertDTO)
    //.subscribe((response) => console.log(response));
  }
}
