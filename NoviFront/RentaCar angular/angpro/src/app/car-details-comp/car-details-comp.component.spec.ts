import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarDetailsCompComponent } from './car-details-comp.component';

describe('CarDetailsCompComponent', () => {
  let component: CarDetailsCompComponent;
  let fixture: ComponentFixture<CarDetailsCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarDetailsCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarDetailsCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
