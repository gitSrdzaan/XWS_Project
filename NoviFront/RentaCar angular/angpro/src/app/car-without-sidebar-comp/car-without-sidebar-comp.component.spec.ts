import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarWithoutSidebarCompComponent } from './car-without-sidebar-comp.component';

describe('CarWithoutSidebarCompComponent', () => {
  let component: CarWithoutSidebarCompComponent;
  let fixture: ComponentFixture<CarWithoutSidebarCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarWithoutSidebarCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarWithoutSidebarCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
