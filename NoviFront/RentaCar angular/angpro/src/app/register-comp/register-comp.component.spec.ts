import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCompComponent } from './register-comp.component';

describe('RegisterCompComponent', () => {
  let component: RegisterCompComponent;
  let fixture: ComponentFixture<RegisterCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
