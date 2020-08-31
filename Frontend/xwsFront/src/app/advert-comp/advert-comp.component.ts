import { Component, OnInit } from '@angular/core';
import { RentService } from '../_services/rent.service';
import RentAdvert from '../_model/rentAdvert.model';

@Component({
  selector: 'app-advert-comp',
  templateUrl: './advert-comp.component.html',
  styleUrls: ['./advert-comp.component.css'],
})
export class AdvertCompComponent implements OnInit {
  ads: Array<RentAdvert>;

  constructor(private rentService: RentService) {}

  ngOnInit(): void {
    this.rentService.getAllAds().subscribe((response) => (this.ads = response));
  }
}
