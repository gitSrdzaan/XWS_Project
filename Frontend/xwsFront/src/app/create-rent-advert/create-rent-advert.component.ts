import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import Car from '../_model/car.model';
import { CarService } from '../_services/car.service';
import { SearchService } from '../_services/search.service';
import { RentService } from '../_services/rent.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-create-rent-advert',
  templateUrl: './create-rent-advert.component.html',
  styleUrls: ['./create-rent-advert.component.css'],
})
export class CreateRentAdvertComponent implements OnInit {
  newRentAdvertForm: FormGroup;
  cars: Array<any>;
  carRegs: Array<String>;
  priceLists: Array<any>;

  constructor(
    private formBuilder: FormBuilder,
    private carService: CarService,
    private rentService: RentService
  ) {
    this.newRentAdvertForm = this.formBuilder.group({
      rentAdvertId: [null],
      carID: [null],
      price: [null],
      firmName: [null],
      userName: [null],
      startDate: [null],
      endDate: [null],
      priceList: [null],
    });
  }

  ngOnInit(): void {
    this.rentService
      .getAllPriceList()
      .subscribe((response) => (this.priceLists = response));
    this.carService
      .getAllCarRegs()
      .subscribe((response) => (this.carRegs = response));
    this.carService
      .getAllCars()
      .subscribe((response) => (this.cars = response));
  }
  submitForm() {
    let rentAdvert = this.newRentAdvertForm.value;
    let val = this.newRentAdvertForm.get('startDate').value;

    console.log('datum ' + rentAdvert.startDate);
    let rentAdvertDTO = {
      rentAdvertId: rentAdvert.rentAdvertId,
      carId: rentAdvert.carID,
      priceForRent: rentAdvert.price,
      firm: rentAdvert.firmName,
      owner_id: rentAdvert.userName,
      advertStartDate: rentAdvert.startDate,
      advertEndDate: rentAdvert.endDate,
      priceListId: rentAdvert.priceList,
    };
    this.rentService
      .addNewRentAdvert(rentAdvertDTO)
      .subscribe((response) => console.log(response));
  }
}
