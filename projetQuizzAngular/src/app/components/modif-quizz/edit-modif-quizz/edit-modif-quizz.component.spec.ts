import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditModifQuizzComponent } from './edit-modif-quizz.component';

describe('EditModifQuizzComponent', () => {
  let component: EditModifQuizzComponent;
  let fixture: ComponentFixture<EditModifQuizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditModifQuizzComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditModifQuizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
