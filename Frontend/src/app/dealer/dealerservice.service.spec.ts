import { TestBed } from '@angular/core/testing';

import { DealerserviceService } from './dealerservice.service';

describe('DealerserviceService', () => {
  let service: DealerserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DealerserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
