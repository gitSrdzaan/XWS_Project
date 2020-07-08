import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutCompComponent } from './about-comp.component';

describe('AboutCompComponent', () => {
  let component: AboutCompComponent;
  let fixture: ComponentFixture<AboutCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
