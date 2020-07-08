import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FaqCompComponent } from './faq-comp.component';

describe('FaqCompComponent', () => {
  let component: FaqCompComponent;
  let fixture: ComponentFixture<FaqCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FaqCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FaqCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
