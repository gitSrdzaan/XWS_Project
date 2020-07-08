import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HelpDeskCompComponent } from './help-desk-comp.component';

describe('HelpDeskCompComponent', () => {
  let component: HelpDeskCompComponent;
  let fixture: ComponentFixture<HelpDeskCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HelpDeskCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HelpDeskCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
