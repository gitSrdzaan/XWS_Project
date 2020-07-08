import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarLeftSidebarComponent } from './car-left-sidebar.component';

describe('CarLeftSidebarComponent', () => {
  let component: CarLeftSidebarComponent;
  let fixture: ComponentFixture<CarLeftSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarLeftSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarLeftSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
