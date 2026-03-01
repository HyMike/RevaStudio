import { TestBed } from '@angular/core/testing';

import { TicketThreadService} from './ticket-thread-service';

describe('TicketThread', () => {
  let service: TicketThreadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketThreadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
