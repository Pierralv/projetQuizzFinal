import { TestBed } from '@angular/core/testing';

import { ObjectToJsonService } from './object-to-json.service';

describe('ObjectToJsonService', () => {
  let service: ObjectToJsonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObjectToJsonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
