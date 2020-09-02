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
  rentService: any;
  constructor(private formBuilder: FormBuilder, rentService: RentService) {
    this.newPriceListForm = this.formBuilder.group({
      PriceListId: [null],
      PricePerDay: [null],
      PricePerKilometer: [null],
      PriceCDW: [null],
      Firm: [null],
    });
  }

  ngOnInit(): void {}

  submitForm() {
    let priceList = this.newPriceListForm.value;
    let priceListDTO = {
      PriceListId: priceList.PriceListId,
      PricePerDay: priceList.PricePerDay,
      PricePerKilometer: priceList.PricePerKilometer,
      PriceCDW: priceList.PriceCDW,
      Firm: priceList.Firm,
    };
    this.rentService
      .addNewPriceList(priceListDTO)
      .subscribe((response) => console.log(response));
  }
}
