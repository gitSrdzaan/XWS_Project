import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverCompComponent } from './driver-comp.component';

describe('DriverCompComponent', () => {
  let component: DriverCompComponent;
  let fixture: ComponentFixture<DriverCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
