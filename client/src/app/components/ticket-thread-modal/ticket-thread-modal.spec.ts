import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketThreadModal } from './ticket-thread-modal';

describe('TicketThreadModal', () => {
  let component: TicketThreadModal;
  let fixture: ComponentFixture<TicketThreadModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketThreadModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketThreadModal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
