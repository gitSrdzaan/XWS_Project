import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationCompComponent } from './registration-comp.component';

describe('RegistrationCompComponent', () => {
  let component: RegistrationCompComponent;
  let fixture: ComponentFixture<RegistrationCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
