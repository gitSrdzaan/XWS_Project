import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleComponentComponent } from './article-component.component';

describe('ArticleComponentComponent', () => {
  let component: ArticleComponentComponent;
  let fixture: ComponentFixture<ArticleComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
