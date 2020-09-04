import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CarService } from '../_services/car.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css'],
})
export class CreateCarComponent implements OnInit {
  newCarForm: FormGroup;
  carMarks: Array<string>;
  carModels: Array<string>;
  carFuels: Array<string>;
  carTransM: Array<string>;
  carClasses: Array<string>;
  constructor(
    private formBuilder: FormBuilder,
    private carService: CarService
  ) {
    this.newCarForm = this.formBuilder.group({
      carRegistration: [null],
      carMark: [null],
      carModel: [null],
      carFuel: [null],
      transmission: [null],
      carClass: [null],
      carMileage: [null],
      maxAllowedMileage: [null],
      kidsSeats: [null],
    });
  }

  ngOnInit(): void {
    this.carService
      .getAllMarks()
      .subscribe((response) => (this.carMarks = response));
    this.carService
      .getAllModels()
      .subscribe((response) => (this.carModels = response));
    this.carService
      .getAllCarFuel()
      .subscribe((response) => (this.carFuels = response));
    this.carService
      .getAllCarTransmission()
      .subscribe((response) => (this.carTransM = response));
    this.carService
      .getAllCarClasses()
      .subscribe((response) => (this.carClasses = response));
  }

  submitForm() {
    //event.preventDefault();

    let car = this.newCarForm.value;
    let carDTO = {
      carRegistration: car.carRegistration,
      carMark: car.carMark,
      carModel: car.carModel,
      carFuel: car.carFuel,
      transmission: car.transmission,
      carClass: car.carClass,
      carMileage: car.carMileage,
      maxAllowedMileage: car.maxAllowedMileage,
      kidsSeats: car.kidsSeats,
      owner_id : 10
    };
    this.carService
      .addNewCar(carDTO)
      .subscribe((response) => console.log(response));
  }
}
