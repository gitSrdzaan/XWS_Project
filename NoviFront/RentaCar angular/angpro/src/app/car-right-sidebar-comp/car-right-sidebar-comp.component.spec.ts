import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarRightSidebarCompComponent } from './car-right-sidebar-comp.component';

describe('CarRightSidebarCompComponent', () => {
  let component: CarRightSidebarCompComponent;
  let fixture: ComponentFixture<CarRightSidebarCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarRightSidebarCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarRightSidebarCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
