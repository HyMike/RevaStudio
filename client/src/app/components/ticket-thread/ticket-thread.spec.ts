import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketThread } from './ticket-thread';

describe('TicketThread', () => {
  let component: TicketThread;
  let fixture: ComponentFixture<TicketThread>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TicketThread]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TicketThread);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
