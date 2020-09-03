import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RentService } from '../_services/rent.service';

@Component({
  selector: 'app-create-pricelist',
  templateUrl: './create-pricelist.component.html',
  styleUrls: ['./create-pricelist.component.css'],
})
export class CreatePricelistComponent implements OnInit {
  newPriceListForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private rentService: RentService
  ) {
    this.newPriceListForm = this.formBuilder.group({
      PriceListId: [null],
      PricePerDay: [null],
      PricePerKilometer: [null],
      PriceCDW: [null],
      Firm: [null],
    });
  }

  ngOnInit(): void {
    this.rentService.getAllAds().subscribe((response) => response);
  }

  submitForm() {
    let priceList = this.newPriceListForm.value;
    let priceListDTO = {
      id: priceList.PriceListId,
      pricePerDay: priceList.PricePerDay,
      pricePerKilometer: priceList.PricePerKilometer,
      priceCDW: priceList.PriceCDW,
      firmID: priceList.Firm,
    };

    console.log(this.rentService);
    this.rentService
      .addNewPriceList(priceListDTO)
      .subscribe((response) => console.log(response));
  }
}
