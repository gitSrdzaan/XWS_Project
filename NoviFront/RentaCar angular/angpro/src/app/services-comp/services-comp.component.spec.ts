import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicesCompComponent } from './services-comp.component';

describe('ServicesCompComponent', () => {
  let component: ServicesCompComponent;
  let fixture: ComponentFixture<ServicesCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicesCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicesCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
