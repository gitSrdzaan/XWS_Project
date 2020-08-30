import { Component, OnInit } from '@angular/core';
import { CarService } from '../_services/car.service';

@Component({
  selector: 'app-advert-comp',
  templateUrl: './advert-comp.component.html',
  styleUrls: ['./advert-comp.component.css'],
})
export class AdvertCompComponent implements OnInit {
  carMarks: Array<string>;
  carModels: Array<string>;
  carClasses: Array<string>;
  transmissions: Array<string>;
  fuelTypes: Array<string>;

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.carService
      .getAllMarks()
      .subscribe((response) => (this.carMarks = response));
    this.carService
      .getAllModels()
      .subscribe((response) => (this.carModels = response));
    this.carService
      .getAllCarClasses()
      .subscribe((response) => (this.carClasses = response));
    this.carService
      .getAllCarTransmission()
      .subscribe((response) => (this.transmissions = response));
    this.carService
      .getAllCarFuel()
      .subscribe((response) => (this.fuelTypes = response));
  }
}
