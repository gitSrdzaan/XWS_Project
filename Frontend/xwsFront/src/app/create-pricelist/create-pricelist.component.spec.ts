import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePricelistComponent } from './create-pricelist.component';

describe('CreatePricelistComponent', () => {
  let component: CreatePricelistComponent;
  let fixture: ComponentFixture<CreatePricelistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatePricelistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePricelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
