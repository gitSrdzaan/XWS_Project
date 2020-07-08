import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertCompComponent } from './advert-comp.component';

describe('AdvertCompComponent', () => {
  let component: AdvertCompComponent;
  let fixture: ComponentFixture<AdvertCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvertCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvertCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
