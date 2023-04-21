import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LienComponent } from './lien.component';

describe('LienComponent', () => {
  let component: LienComponent;
  let fixture: ComponentFixture<LienComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LienComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LienComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
