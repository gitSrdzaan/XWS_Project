import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GalleryCompComponent } from './gallery-comp.component';

describe('GalleryCompComponent', () => {
  let component: GalleryCompComponent;
  let fixture: ComponentFixture<GalleryCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GalleryCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GalleryCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
