import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageCompComponent } from './package-comp.component';

describe('PackageCompComponent', () => {
  let component: PackageCompComponent;
  let fixture: ComponentFixture<PackageCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackageCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
