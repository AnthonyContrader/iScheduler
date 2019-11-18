import { TestBed } from '@angular/core/testing';

import { RecruiterService } from './recruiter.service';

describe('RecruiterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RecruiterService = TestBed.get(RecruiterService);
    expect(service).toBeTruthy();
  });
});
