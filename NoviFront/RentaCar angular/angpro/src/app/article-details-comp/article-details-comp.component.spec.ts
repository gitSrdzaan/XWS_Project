import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleDetailsCompComponent } from './article-details-comp.component';

describe('ArticleDetailsCompComponent', () => {
  let component: ArticleDetailsCompComponent;
  let fixture: ComponentFixture<ArticleDetailsCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleDetailsCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleDetailsCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
