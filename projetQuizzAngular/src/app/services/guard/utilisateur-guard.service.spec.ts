import { TestBed } from '@angular/core/testing';

import { UtilisateurGuardService } from './utilisateur-guard.service';

describe('UtilisateurGuardService', () => {
  let service: UtilisateurGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtilisateurGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
