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

  ngOnInit(): void {}

  submitForm() {
    let car = this.newCarForm.value;
    let carDTO = {
      carRegistration: car.carRegistration,
      carMark: car.carMark,
      carModel: car.carModel,
      carFuel: {
        fuel: car.carFuel,
      },
      transmission: {
        transmission: car.transmission,
      },
      carClass: car.carClass,
      carMileage: car.carMileage,
      maxAllowedMileage: car.maxAllowedMileage,
      kidsSeats: car.kidsSeats,
    };
    this.carService
      .addNewCar(carDTO)
      .subscribe((response) => console.log(response));
  }
}