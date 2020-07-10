import { Component, OnInit } from '@angular/core';
import { RentService } from '../_services/rent.service';

@Component({
  selector: 'app-shopping-cart-comp',
  templateUrl: './shopping-cart-comp.component.html',
  styleUrls: ['./shopping-cart-comp.component.css'],
})
export class ShoppingCartCompComponent implements OnInit {
  myCart: Array<any>;
  displayedColumns: Array<string>;
  constructor(private rentService: RentService) {
    this.displayedColumns = ['id', 'carMark', 'carModel', 'cart', 'request'];
  }

  ngOnInit(): void {
    this.myCart = JSON.parse(localStorage.getItem('myCart'));
    if (this.myCart === null) this.myCart = [];
    console.log(this.myCart);
  }

  removeFromCart(id) {
    console.log(id);
    this.myCart = this.myCart.filter((item) => item.id !== id);
    localStorage.removeItem('myCart');
    localStorage.setItem('myCart', JSON.stringify(this.myCart));
  }

  sendRequest(item) {
    this.rentService.rent(item).subscribe((response) => {
      console.log(response);
      this.removeFromCart(item.id);
    });
  }

  sendRequestAll() {
    if (this.myCart === null || this.myCart.length === 0) return;
    this.rentService.rentBundle(this.myCart).subscribe((response) => {
      console.log(response);
      this.myCart = [];
      localStorage.removeItem('myCart');
      localStorage.setItem('myCart', JSON.stringify(this.myCart));
    });
  }
}
