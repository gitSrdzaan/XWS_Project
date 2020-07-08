import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Index2CompComponent } from './index2-comp.component';

describe('Index2CompComponent', () => {
  let component: Index2CompComponent;
  let fixture: ComponentFixture<Index2CompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Index2CompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Index2CompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
