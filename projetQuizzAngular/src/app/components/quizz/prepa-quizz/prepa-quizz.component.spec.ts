import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrepaQuizzComponent } from './prepa-quizz.component';

describe('PrepaQuizzComponent', () => {
  let component: PrepaQuizzComponent;
  let fixture: ComponentFixture<PrepaQuizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrepaQuizzComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrepaQuizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
