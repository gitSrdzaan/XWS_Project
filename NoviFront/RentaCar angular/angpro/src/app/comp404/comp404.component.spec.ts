import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Comp404Component } from './comp404.component';

describe('Comp404Component', () => {
  let component: Comp404Component;
  let fixture: ComponentFixture<Comp404Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Comp404Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Comp404Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
