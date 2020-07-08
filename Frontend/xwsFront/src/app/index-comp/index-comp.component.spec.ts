import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexCompComponent } from './index-comp.component';

describe('IndexCompComponent', () => {
  let component: IndexCompComponent;
  let fixture: ComponentFixture<IndexCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndexCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndexCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
