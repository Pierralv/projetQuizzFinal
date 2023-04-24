import { TestBed } from '@angular/core/testing';

import { CompteServiceService } from './compte-service.service';

describe('CompteServiceService', () => {
  let service: CompteServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompteServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
