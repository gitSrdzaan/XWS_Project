import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Index3CompComponent } from './index3-comp.component';

describe('Index3CompComponent', () => {
  let component: Index3CompComponent;
  let fixture: ComponentFixture<Index3CompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Index3CompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Index3CompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
