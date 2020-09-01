import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRentAdvertComponent } from './create-rent-advert.component';

describe('CreateRentAdvertComponent', () => {
  let component: CreateRentAdvertComponent;
  let fixture: ComponentFixture<CreateRentAdvertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateRentAdvertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRentAdvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
