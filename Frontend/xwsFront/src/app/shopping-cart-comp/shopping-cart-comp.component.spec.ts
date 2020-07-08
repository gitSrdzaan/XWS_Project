import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingCartCompComponent } from './shopping-cart-comp.component';

describe('ShoppingCartCompComponent', () => {
  let component: ShoppingCartCompComponent;
  let fixture: ComponentFixture<ShoppingCartCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShoppingCartCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoppingCartCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
