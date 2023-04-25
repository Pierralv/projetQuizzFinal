import { TestBed } from '@angular/core/testing';

import { NonAdminGuardService } from './non-admin-guard.service';

describe('NonAdminGuardService', () => {
  let service: NonAdminGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NonAdminGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
