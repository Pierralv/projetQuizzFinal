import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoixAvatarComponent } from './choix-avatar.component';

describe('ChoixAvatarComponent', () => {
  let component: ChoixAvatarComponent;
  let fixture: ComponentFixture<ChoixAvatarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChoixAvatarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChoixAvatarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
